package com.pm.GeoCachePortalV2Api.Dto;

import com.pm.GeoCachePortalV2Api.Models.ApplicationRole;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ApplicationUserResponseDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    List<ApplicationRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ApplicationRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ApplicationRole> roles) {
        this.roles = roles;
    }

}