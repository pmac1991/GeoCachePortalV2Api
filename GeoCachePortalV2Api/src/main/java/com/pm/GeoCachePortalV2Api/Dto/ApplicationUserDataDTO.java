package com.pm.GeoCachePortalV2Api.Dto;

import com.pm.GeoCachePortalV2Api.Models.ApplicationRole;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ApplicationUserDataDTO {
    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    List<ApplicationRole> roles;

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