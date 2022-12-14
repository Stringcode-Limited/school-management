package com.stringcodeltd.studentapp.service;

import com.stringcodeltd.studentapp.dao.AddressRepository;
import com.stringcodeltd.studentapp.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressrepo;

    public List<Address> getAllAddressDetails(){
        return addressrepo.findAll();
    }


    public String updateaddress(Long id, Address addid){
        if(addressrepo.existsById(id)){
            Address addr =  addressrepo.findById(id).get();
            addr.setState(addid.getState());
            addr.setCity(addid.getCity());
            addr.setStreet(addid.getStreet());
            addr.setType(addid.getType());
            addressrepo.save(addr);
            return "updated";
        }

        return null;
    }
}
