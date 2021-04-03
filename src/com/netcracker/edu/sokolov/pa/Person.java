package com.netcracker.edu.sokolov.pa;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Class for persons. All persons have first name, last name, date of their birth and one address.
 * @author kirillsokolov
 * @version 1.1
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Address address;

    public Person(String firstName, String lastName, LocalDate birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
