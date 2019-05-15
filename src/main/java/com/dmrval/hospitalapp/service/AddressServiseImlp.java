package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.dao.AddressDao;
import com.dmrval.hospitalapp.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiseImlp implements AddressServise {
    @Autowired
    AddressDao addressDao;

    @Override
    public List<Address> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public void addAddress(Address address) {
        addressDao.addAddress(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public void removeAddress(int id) {
        addressDao.removeAddress(id);
    }

    @Override
    public Address getAddress(int id) {
        return addressDao.getAddress(id);
    }
}
