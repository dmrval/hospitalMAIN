package com.dmrval.hospitalapp.service;


import com.dmrval.hospitalapp.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();

    void addAddress(Address address);

    void updateAddress(Address address);

    void removeAddress(int id);

    Address getAddress(int id);
}
