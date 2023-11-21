package com.barclays.controller;

import com.barclays.model.Address;
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

import static org.junit.jupiter.api.Assertions.*;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class PersonTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper;
    ResultActions resultActions;

    @Test
    public void testGettingAllPeople() throws Exception {
        int expectedLength = 4;

        mapper = new ObjectMapper();

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/people")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Person[] people = mapper.readValue(contentAsString, Person[].class);

        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, people.length),
                () -> assertEquals("first person", people[0].getName()),
                () -> assertEquals("second person", people[1].getName()),
                () -> assertEquals("third person", people[2].getName()),
                () -> assertEquals("fourth person", people[3].getName())
        );
    }

    @Test
    public void testCreatePerson() throws Exception {
        Person person = new Person();
        person.setName("Shona");

        Address address = new Address();
        address.setLineOne("Line One");
        address.setLineTwo("Line Two");
        address.setState("State");
        address.setPostalCode("Postcode");
        address.setCountry("Country");

        person.setAddress(address);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/people")
                        .content(mapper.writeValueAsString(person))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        person = mapper.readValue(contentAsString, Person.class);

        assertEquals(1, person.getId());
    }

    @Test
    public void testDeletePerson() throws Exception {
        int id = 200;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/people/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        assertEquals("", contentAsString);
    }
}
