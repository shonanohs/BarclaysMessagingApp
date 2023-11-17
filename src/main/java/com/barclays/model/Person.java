package com.barclays.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST) // Save address and person
    private Address address;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<PhoneNumber> phoneNumbers;

    public Person (String name) {
        this.name = name;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
