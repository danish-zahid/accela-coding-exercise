package com.accela.coding.exercise.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Person person;
}
