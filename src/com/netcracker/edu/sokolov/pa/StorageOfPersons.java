package com.netcracker.edu.sokolov.pa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for storage of persons in witch we can put all persons and then search in storage by different parameters.
 *
 * @author kirillsokolov
 * @version 1.1
 */
public class StorageOfPersons {
    private List<Person> personList;

    public StorageOfPersons(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> searchByLastName(String lastName) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personList) {
            if (person.getLastName().equals(lastName)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public List<Person> searchByAddressAttribute(AddressAttribute attribute, String text) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAddress().getAddressMap().get(attribute).equals(text)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public List<Person> searchBornBetweenDates(LocalDate date1, LocalDate date2) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personList) {
            if (person.getBirthDate().isAfter(date1) && person.getBirthDate().isBefore(date2)) {
                persons.add(person);
            }
        }
        return persons;
    }

    public Person searchOldestPerson() {
        LocalDate min = LocalDate.MAX;
        Person oldestPerson = null;
        for (Person person : personList) {
            if (person.getBirthDate().isBefore(min)) {
                min = person.getBirthDate();
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

    public Person searchYoungestPerson() {
        LocalDate max = LocalDate.MIN;
        Person youngestPerson = null;
        for (Person person : personList) {
            if (person.getBirthDate().isAfter(max)) {
                max = person.getBirthDate();
                youngestPerson = person;
            }
        }
        return youngestPerson;
    }

    public List<Person> searchLivingOnOneStreet() {
        List<Person> persons = new ArrayList<>();
        Set<String> streets = new HashSet<>();
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            String personsStreet = person.getAddress().getAddressMap().get(AddressAttribute.STREET);
            if (!streets.add(personsStreet)) {
                persons.add(person);
                //loop to find and add person from the street: this person is already in list persons.
                for (int j = 0; j < personList.indexOf(person); j++) {
                    Person person1 = personList.get(j);
                    String persons1Street = person1.getAddress().getAddressMap().get(AddressAttribute.STREET);
                    if (persons1Street.equals(personsStreet)) {
                        if (!persons.contains(person1)) {
                            persons.add(person1);
                            break;
                        }
                    }
                }
            }
        }
        return persons;
    }
}
