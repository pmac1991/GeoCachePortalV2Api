package com.pm.GeoCachePortalV2Api.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;


    @ElementCollection(fetch = FetchType.EAGER)
    List<ApplicationRole> roles;

}
