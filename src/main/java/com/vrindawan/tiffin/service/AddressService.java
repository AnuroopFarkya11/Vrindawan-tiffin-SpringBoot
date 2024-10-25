package com.vrindawan.tiffin.service;

import com.vrindawan.tiffin.model.user.Address;
import com.vrindawan.tiffin.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;


    @Transactional
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public boolean isAddressPresent(Address address)
    {
        if(address.getAddressId()==null)
        {
            return false;
        }
        return addressRepository.existsByaddressId(address.getAddressId());
    }


}
