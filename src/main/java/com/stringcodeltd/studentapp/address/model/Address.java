package com.stringcodeltd.studentapp.address.model;

import com.stringcodeltd.studentapp.enums.Addresstype;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String state;
    @Enumerated(EnumType.STRING)
    private Addresstype type;

}
