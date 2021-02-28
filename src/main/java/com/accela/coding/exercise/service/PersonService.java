package com.accela.coding.exercise.service;

import com.accela.coding.exercise.dto.PersonDTO;
import com.accela.coding.exercise.entities.Person;

import java.util.List;

public interface PersonService {
    Long getPersonCount();

    List<Person> getAllPersonList();

    Person getPersonById(Integer id);

    void deletePerson(Integer id);

    Person addPerson(PersonDTO personDTo);

    Person editPerson(Integer id, PersonDTO personDTO);
}
