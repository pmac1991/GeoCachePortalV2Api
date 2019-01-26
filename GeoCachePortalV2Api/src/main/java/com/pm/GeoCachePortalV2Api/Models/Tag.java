package com.pm.GeoCachePortalV2Api.Models;


import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(generator = "tag_generator")
    @SequenceGenerator(
            name = "tag_generator",
            sequenceName = "tag_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column
    private String name;
}
