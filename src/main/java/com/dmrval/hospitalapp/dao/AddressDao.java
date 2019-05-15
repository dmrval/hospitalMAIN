package com.dmrval.hospitalapp.dao;

import com.dmrval.hospitalapp.entity.Address;

import java.util.List;

public interface AddressDao {
    List<Address> getAllAddress();
    void addAddress(Address address);
    void updateAddress(Address address);
    void removeAddress(int id);
    Address getAddress(int id);
}
