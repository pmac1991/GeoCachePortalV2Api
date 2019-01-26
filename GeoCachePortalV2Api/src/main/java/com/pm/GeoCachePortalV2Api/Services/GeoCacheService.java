package com.pm.GeoCachePortalV2Api.Services;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Repositories.GeoCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.List;

@Service
public class GeoCacheService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private GeoCacheRepository geoCacheRepository;

    public List<GeoCache> getGeoCachesForUser(){
        return geoCacheRepository.findByCreator(currentUserService.getCurrentUserFromSecurityContext());
    }

    public GeoCache saveGeoCacheForCurrentUser(GeoCache geoCache){
        geoCache.setCreator(currentUserService.getCurrentUserFromSecurityContext());
        return geoCacheRepository.save(geoCache);
    }

}
