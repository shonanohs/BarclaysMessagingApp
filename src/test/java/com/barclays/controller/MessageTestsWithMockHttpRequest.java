package com.barclays.controller;

import com.barclays.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class MessageTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper;
    ResultActions resultActions;

    @Test
    public void testGettingAllMessages() throws Exception {
        int expectedLength = 4;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Message[] messages = mapper.readValue(contentAsString, Message[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, messages.length),
                () -> assertEquals("first message", messages[0].getContent()),
                () -> assertEquals("second message", messages[1].getContent()),
                () -> assertEquals("third message", messages[2].getContent()),
                () -> assertEquals("fourth message", messages[3].getContent())
                );
    }

    @Test
    public void testCreateMessage() throws Exception {
        Message message = new Message("test message");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                        .content(mapper.writeValueAsString(message))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        message = mapper.readValue(contentAsString, Message.class);

        assertEquals(1, message.getId());
    }

    @Test
    public void testDeleteMessage() throws Exception {
        int id = 200;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/messages/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        assertEquals("", contentAsString);
    }
}
