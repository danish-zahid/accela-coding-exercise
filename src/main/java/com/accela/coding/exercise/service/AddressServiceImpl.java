package com.accela.coding.exercise.service;

import com.accela.coding.exercise.dto.AddressDTO;
import com.accela.coding.exercise.entities.Address;
import com.accela.coding.exercise.entities.Person;
import com.accela.coding.exercise.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address addAddress(AddressDTO addressDTo) {
        Address address = addressDTo.copy(new Address());
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public List<Address> addAddresses(Person person, List<AddressDTO> addressDTOs) {
        return addressDTOs.stream()
                .map(addressDTO -> {
                    Address address = addressDTO.copy(new Address());
                    address.setPerson(person);
                    return addressRepository.save(address);
                }).collect(Collectors.toList());
    }


    @Override
    public Address editAddress(Integer id, AddressDTO addressDTO) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address addressEntity = address.get();
            addressEntity = addressDTO.copy(addressEntity);
            addressRepository.save(addressEntity);
            return addressEntity;
        } else {
            return null;
        }
    }
}
