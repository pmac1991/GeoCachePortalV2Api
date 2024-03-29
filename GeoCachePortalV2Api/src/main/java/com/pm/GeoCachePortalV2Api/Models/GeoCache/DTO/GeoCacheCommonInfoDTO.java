package com.pm.GeoCachePortalV2Api.Models.GeoCache.DTO;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.DTO.ApplicationUserDataDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.Tag;
import lombok.Data;

import java.util.List;

@Data
public class GeoCacheCommonInfoDTO {

    private Long id;

    private String name;

    private String description;

    private List<Tag> tagList;

    private List<ApplicationUserDataDTO> visitors;

    private ApplicationUserDataDTO creator;

}
