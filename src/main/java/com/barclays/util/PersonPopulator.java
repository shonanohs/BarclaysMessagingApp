package com.barclays.util;

import com.barclays.model.Address;
import com.barclays.model.Person;
import com.barclays.model.PhoneNumber;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PersonPopulator {
    private PersonRepository personRepository;

   //@EventListener(ContextRefreshedEvent.class) // don't have to call populate in main if using this
    public void populate() {
        Person person = new Person();
        person.setName("Shona");

        Address address = new Address();
        address.setLineOne("Line One");
        address.setLineTwo("Line Two");
        address.setState("State");
        address.setPostalCode("AB1 2CD");
        address.setCountry("Country");

        person.setAddress(address);

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setCountryCode("+44");
        phoneNumber1.setNumber("07111222333");

        PhoneNumber phoneNumber2 = new PhoneNumber();
        phoneNumber2.setCountryCode("+44");
        phoneNumber2.setNumber("07444555666");

        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        person.setPhoneNumbers(phoneNumbers);

        personRepository.save(person);
    }
}
