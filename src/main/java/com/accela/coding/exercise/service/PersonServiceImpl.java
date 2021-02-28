package com.accela.coding.exercise.service;

import com.accela.coding.exercise.dto.PersonDTO;
import com.accela.coding.exercise.entities.Person;
import com.accela.coding.exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Long getPersonCount() {
        return personRepository.count();
    }

    @Override
    public List<Person> getAllPersonList() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person addPerson(PersonDTO personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public Person editPerson(Integer id, PersonDTO personDTO) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person personEntity = person.get();
            personEntity.setFirstName(personDTO.getFirstName());
            personEntity.setLastName(personDTO.getLastName());
            personRepository.save(personEntity);
            return personEntity;
        } else {
            return null;
        }
    }

}
