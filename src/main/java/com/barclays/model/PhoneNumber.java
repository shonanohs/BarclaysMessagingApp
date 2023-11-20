package com.barclays.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Integer id;
    private String countryCode;
    private String number;
}
