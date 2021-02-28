package com.accela.coding.exercise.controller;

import com.accela.coding.exercise.dto.AddressDTO;
import com.accela.coding.exercise.dto.Response;
import com.accela.coding.exercise.entities.Address;
import com.accela.coding.exercise.exception.ResourceNotFoundException;
import com.accela.coding.exercise.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.accela.coding.exercise.util.Constants.SUCCESS;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @DeleteMapping("/{id}")
    public Response<Address> deleteAddressById(@Validated @PathVariable Integer id) {
        addressService.deleteAddress(id);
        return new Response<>(SUCCESS);
    }


    @PutMapping("/{id}")
    public Response<Address> editAddress(@PathVariable Integer id, @Validated @RequestBody AddressDTO addressDTO) {
        Address address = addressService.editAddress(id, addressDTO);
        if (address == null) {
            throw new ResourceNotFoundException(String.format("Address with id %d not Found", id));
        }
        return new Response<>(SUCCESS, address);
    }

}
