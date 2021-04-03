package com.netcracker.edu.sokolov.pa;

import java.time.LocalDate;
import java.util.*;

/**
 * Class for testing storageOfPersons class and all it's methods
 *
 * @author kirillsokolov
 * @version 1.1
 */
public class PAMain {
    public static void main(String[] args) {
        //We put demo-persons to our storage
        StorageOfPersons storageOfPersons = new StorageOfPersons(demoPersonList());

        System.out.println("1) Search on second name:");
        storageOfPersons.searchByLastName("Noy")
                .forEach(person -> System.out.println(person.getFullName()));
        System.out.println();

        System.out.println("2) Search on Address Attribute:");
        storageOfPersons.searchByAddressAttribute(AddressAttribute.BUILDING, "31")
                .forEach(person -> System.out.println(person.getFullName()));
        System.out.println();

        System.out.println("3) Born between dates:");
        storageOfPersons.searchBornBetweenDates(LocalDate.of(1999, 1, 1), LocalDate.of(2000, 2, 2))
                .forEach(person -> System.out.println(person.getFullName()));
        System.out.println();

        System.out.println("4.1) The oldest person:");
        System.out.println(storageOfPersons.searchOldestPerson().getFullName());
        System.out.println();

        System.out.println("4.2) The youngest person:");
        System.out.println(storageOfPersons.searchYoungestPerson().getFullName());
        System.out.println();

        System.out.println("5) Live on one street:");
        storageOfPersons.searchLivingOnOneStreet().forEach(person -> System.out.println(person.getFullName()));
        System.out.println();

    }

    /**
     * Method for creating list of persons with demo data
     *
     * @return list of persons
     */
    private static List<Person> demoPersonList() {
        Map<AddressAttribute, String> addressMap1 = new HashMap<>();
        putCountryRegionCityDistrict(addressMap1);
        addressMap1.put(AddressAttribute.STREET, "Pervomayskaya");
        addressMap1.put(AddressAttribute.BUILDING, "11");
        addressMap1.put(AddressAttribute.APARTMENT, "1");

        Map<AddressAttribute, String> addressMap2 = new HashMap<>();
        putCountryRegionCityDistrict(addressMap2);
        addressMap2.put(AddressAttribute.STREET, "Proletarskaya");
        addressMap2.put(AddressAttribute.BUILDING, "26");
        addressMap2.put(AddressAttribute.APARTMENT, "29");

        Map<AddressAttribute, String> addressMap3 = new HashMap<>();
        putCountryRegionCityDistrict(addressMap3);
        addressMap3.put(AddressAttribute.STREET, "Pervomayskaya");
        addressMap3.put(AddressAttribute.BUILDING, "11");
        addressMap3.put(AddressAttribute.APARTMENT, "2");

        Map<AddressAttribute, String> addressMap4 = new HashMap<>();
        putCountryRegionCityDistrict(addressMap4);
        addressMap4.put(AddressAttribute.STREET, "Vinnaya");
        addressMap4.put(AddressAttribute.BUILDING, "31");
        addressMap4.put(AddressAttribute.APARTMENT, "19");

        Address address1 = new Address(addressMap1);
        Person person1 = new Person("Kirill", "Sokolov", LocalDate.of(1999, 9, 6), address1);
        Address address2 = new Address(addressMap2);
        Person person2 = new Person("Vadim", "Ermakov", LocalDate.of(2000, 1, 8), address2);
        Address address3 = new Address(addressMap3);
        Person person3 = new Person("Ruslan", "Beliy", LocalDate.of(1985, 9, 29), address3);
        Address address4 = new Address(addressMap4);
        Person person4 = new Person("Anna", "Noy", LocalDate.of(1993, 10, 2), address4);

        return new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
    }

    /**
     * Method for putting demo data(country, region, city, district) into address for code duplicate remove
     *
     * @param addressMap address of the person
     */
    private static void putCountryRegionCityDistrict(Map<AddressAttribute, String> addressMap) {
        addressMap.put(AddressAttribute.COUNTRY, "Russia");
        addressMap.put(AddressAttribute.REGION, "МО");
        addressMap.put(AddressAttribute.CITY, "Moscow");
        addressMap.put(AddressAttribute.DISTRICT, "Izmaylovo");
    }
}
