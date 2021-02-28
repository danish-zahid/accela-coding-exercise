package com.accela.coding.exercise.service;

import com.accela.coding.exercise.dto.PersonDTO;
import com.accela.coding.exercise.entities.Person;
import com.accela.coding.exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person addPerson(PersonDTO personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return personRepository.save(person);
    }
}
