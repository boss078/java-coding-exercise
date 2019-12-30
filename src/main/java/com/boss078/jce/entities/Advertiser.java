package com.boss078.jce.entities;

import javax.persistence.*;

@Entity
@Table(name = "ADVERTISER")
public class Advertiser {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CREDIT_LIMIT")
    private float creditLimit;

}
