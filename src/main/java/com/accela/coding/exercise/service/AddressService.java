package com.accela.coding.exercise.service;

import com.accela.coding.exercise.dto.AddressDTO;
import com.accela.coding.exercise.entities.Address;
import com.accela.coding.exercise.entities.Person;

import java.util.List;

public interface AddressService {
    Address getAddressById(Integer id);

    void deleteAddress(Integer id);

    Address addAddress(AddressDTO addressDTo);

    List<Address> addAddresses(Person person, List<AddressDTO> addressDTOs);

    Address editAddress(Integer id, AddressDTO addressDTO);
}
