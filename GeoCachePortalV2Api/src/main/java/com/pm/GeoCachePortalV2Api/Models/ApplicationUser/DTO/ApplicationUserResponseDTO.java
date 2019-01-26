package com.pm.GeoCachePortalV2Api.Models.ApplicationUser.DTO;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApplicationUserResponseDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    List<ApplicationRole> roles;

}