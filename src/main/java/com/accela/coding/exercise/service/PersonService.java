package com.accela.coding.exercise.service;

import com.accela.coding.exercise.dto.PersonDTO;
import com.accela.coding.exercise.entities.Person;

public interface PersonService {
    Person getPersonById(Integer id);

    Person addPerson(PersonDTO personDto);
}
