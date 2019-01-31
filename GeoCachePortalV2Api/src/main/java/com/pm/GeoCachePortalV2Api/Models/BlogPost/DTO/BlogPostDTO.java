package com.pm.GeoCachePortalV2Api.Models.BlogPost.DTO;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.DTO.ApplicationUserDataDTO;
import lombok.Data;

@Data
public class BlogPostDTO {
    private Long id;

    private String textContents;

    private ApplicationUserDataDTO creator;
}
