package com.netcracker.edu.sokolov.pa;

import java.util.Map;

/**
 * Class for addresses of persons. Address consists from different attributes like country,city...
 * All these attributes are stored in addressMap. Key is type of attribute and value is string of address.
 * @author kirillsokolov
 * @version 1.1
 */
public class Address {
    private final Map<AddressAttribute,String> addressMap;


    public Address(Map<AddressAttribute,String> addressMap) {
       this.addressMap = addressMap;
    }

    public Map<AddressAttribute, String> getAddressMap() {
        return addressMap;
    }
}
