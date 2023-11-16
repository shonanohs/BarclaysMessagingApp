package com.barclays.controller;

import com.barclays.model.Person;
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
public class PersonTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGettingAllPeople() throws Exception {
        int expectedLength = 8;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/people")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Person[] people = mapper.readValue(contentAsString, Person[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, people.length),
                () -> assertEquals("Person 1", people[0].getName()),
                () -> assertEquals("Person 2", people[1].getName()),
                () -> assertEquals("Person 3", people[2].getName()),
                () -> assertEquals("Person 4", people[3].getName()),
                () -> assertEquals("first person", people[4].getName()),
                () -> assertEquals("second person", people[5].getName()),
                () -> assertEquals("third person", people[6].getName()),
                () -> assertEquals("fourth person", people[7].getName())
        );
    }
}
