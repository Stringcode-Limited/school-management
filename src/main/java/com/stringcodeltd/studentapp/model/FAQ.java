package com.stringcodeltd.studentapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Setter
@Getter
@Transactional
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "FAQ")
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAQ_id")
    private int id;

    @Column
    private String question;

    @Column
    private String answer;


}