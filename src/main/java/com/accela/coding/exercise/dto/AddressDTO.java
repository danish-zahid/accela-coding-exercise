package com.accela.coding.exercise.dto;

import com.accela.coding.exercise.entities.Address;
import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String postalCode;

    public Address copy(Address addressEntity) {
        addressEntity.setStreet(getStreet());
        addressEntity.setCity(getCity());
        addressEntity.setState(getState());
        addressEntity.setPostalCode(getPostalCode());
        return addressEntity;
    }
}
