package com.accela.coding.exercise.unit;

import com.accela.coding.exercise.dto.PersonDTO;
import com.accela.coding.exercise.entities.Person;
import com.accela.coding.exercise.repository.PersonRepository;
import com.accela.coding.exercise.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceUnitTest {

    @MockBean
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Test
    public void givenPersonCountMocked_WhenGetInvoked_ThenMockedValueReturned() throws Exception {
        when(personRepository.count()).thenReturn(5L);
        assertEquals(5L, personService.getPersonCount());
    }

    @Test
    public void givenPersonMocked_WhenGetInvoked_ThenMockedValueReturned() throws Exception {
        Person person = new Person(1, "FirstName", "LastName", null);
        when(personRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(person));
        assertEquals(person, personService.getPersonById(Mockito.anyInt()));
    }

    @Test
    public void givenPersonMocked_WhenPostInvoked_ThenMockedValueReturned() throws Exception {
        Person person = new Person(1, "FirstName", "LastName", null);
        when(personRepository.save(Mockito.any())).thenReturn(person);
        Person personEntity = personService.addPerson(Mockito.mock(PersonDTO.class));
        assertNotNull(personEntity);
        assertEquals(person.getFirstName(),person.getFirstName());
        assertEquals(person.getLastName(),person.getLastName());
    }

}
