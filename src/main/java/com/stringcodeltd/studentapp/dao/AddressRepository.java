package com.stringcodeltd.studentapp.dao;

import com.stringcodeltd.studentapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
