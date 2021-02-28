package com.accela.coding.exercise.integration;

import com.accela.coding.exercise.controller.PersonController;
import com.accela.coding.exercise.entities.Person;
import com.accela.coding.exercise.repository.PersonRepository;
import com.accela.coding.exercise.service.AddressService;
import com.accela.coding.exercise.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @MockBean
    AddressService addressService;

    @Test
    public void givenPersonMocked_WhenGetInvoked_ThenMockValueReturned() throws Exception {
        Integer id = 1;
        Person person = new Person(1, "FirstName", "LastName", null);
        given(personService.getPersonById(id)).willReturn(person);

        mockMvc.perform(MockMvcRequestBuilders.get("/person/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void givenPersonNotAvailable_WhenGetInvoked_ThenNotFoundStatusReturned() throws Exception {
        mockMvc.perform(get("/person/{id}", Mockito.anyInt())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
