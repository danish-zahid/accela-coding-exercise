package com.accela.coding.exercise.controller;

import com.accela.coding.exercise.dto.AddressDTO;
import com.accela.coding.exercise.dto.PersonDTO;
import com.accela.coding.exercise.dto.Response;
import com.accela.coding.exercise.entities.Address;
import com.accela.coding.exercise.entities.Person;
import com.accela.coding.exercise.exception.ResourceNotFoundException;
import com.accela.coding.exercise.service.AddressService;
import com.accela.coding.exercise.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.accela.coding.exercise.util.Constants.SUCCESS;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    AddressService addressService;

    @GetMapping("/{id}")
    public Response<Person> getPersonById(@Validated @PathVariable Integer id) {
        Person person = personService.getPersonById(id);
        if (person == null) {
            throw new ResourceNotFoundException(String.format("Person with id %d not Found", id));
        }
        return new Response<>(SUCCESS, person);
    }

    @DeleteMapping("/{id}")
    public Response<Person> deletePersonById(@Validated @PathVariable Integer id) {
        personService.deletePerson(id);
        return new Response<>(SUCCESS);
    }

    @PostMapping("/")
    public Response<Person> addPerson(@Validated @RequestBody PersonDTO personDto) {
        Person person = personService.addPerson(personDto);
        return new Response<>(SUCCESS, person);
    }

    @PutMapping("/{id}")
    public Response<Person> editPerson(@Validated @RequestBody PersonDTO personDto, @PathVariable Integer id) {
        Person person = personService.editPerson(id, personDto);
        if (person == null) {
            throw new ResourceNotFoundException(String.format("Person with id %d not Found", id));
        }
        return new Response<>(SUCCESS, person);
    }

    @GetMapping("/all")
    public Response<List<Person>> getAll() {
        List<Person> persons = personService.getAllPersonList();
        if (persons == null || persons.isEmpty()) {
            throw new ResourceNotFoundException("No Persons found");
        }
        return new Response<>(SUCCESS, persons);
    }

    @PostMapping("/{personId}/addresses")
    public Response<List<Address>> addAddressesToPerson(@PathVariable Integer personId, @RequestBody List<AddressDTO> addressDTOs) {
        Person personEntity = personService.getPersonById(personId);
        if (personEntity == null) {
            throw new ResourceNotFoundException(String.format("Person with id %d not Found", personId));
        }
        return new Response<>(SUCCESS, addressService.addAddresses(personEntity, addressDTOs));
    }
}
