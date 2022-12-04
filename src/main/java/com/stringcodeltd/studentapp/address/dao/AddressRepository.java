package com.stringcodeltd.studentapp.address.dao;

import com.stringcodeltd.studentapp.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
