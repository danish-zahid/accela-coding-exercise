package com.accela.coding.exercise.dto;

import com.accela.coding.exercise.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String postalCode;

    public Address copy(Address addressEntity) {
        //TODO This can be improved if using mapstruct - will add i have more time
        addressEntity.setStreet(getStreet());
        addressEntity.setCity(getCity());
        addressEntity.setState(getState());
        addressEntity.setPostalCode(getPostalCode());
        return addressEntity;
    }
}
