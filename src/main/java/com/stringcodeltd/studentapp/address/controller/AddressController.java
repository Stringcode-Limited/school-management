package com.stringcodeltd.studentapp.address.controller;

import com.stringcodeltd.studentapp.address.model.Address;
import com.stringcodeltd.studentapp.address.service.AddressService;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/vi/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping()
    public List<Address> getallStudent(){return addressService.getAllAddressDetails();
    }

    @PutMapping("/{id}")
    public String  updateAddresst(@PathVariable(name="id")Long id, @Valid @RequestBody Address addrress){
        return addressService.updateaddress(id,addrress);

    }
}
