package com.pm.GeoCachePortalV2Api.Services;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Repositories.GeoCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.security.AccessControlException;
import java.util.List;
import java.util.Optional;

@Service
public class GeoCacheService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private GeoCacheRepository geoCacheRepository;

    public Page<GeoCache> getGeoCachesForUser(Pageable pageable){
        return geoCacheRepository.findByCreator(currentUserService.getCurrentUserFromSecurityContext(),pageable);
    }

    public GeoCache saveGeoCacheForCurrentUser(GeoCache geoCache){
        geoCache.setCreator(currentUserService.getCurrentUserFromSecurityContext());
        return geoCacheRepository.save(geoCache);
    }

    public GeoCache updateGeoCache(GeoCache geoCache, Long id) throws IllegalArgumentException, AccessControlException{

        Optional<GeoCache> geoCacheOptional = geoCacheRepository.findById(id);

        if(!geoCacheOptional.isPresent())
            throw new IllegalArgumentException("There is no Geocache with id: " + id);

        ApplicationUser applicationUser = currentUserService.getCurrentUserFromSecurityContext();

        GeoCache geoCacheFromDb = geoCacheOptional.get();

        if(geoCacheFromDb.getCreator().getId() != applicationUser.getId())
            throw new AccessControlException("Current user does not have acces to this geocache");

        geoCache.setId(id);

        return geoCacheRepository.save(geoCache);
    }

    public void deleteGeoCache(Long id) throws IllegalArgumentException, AccessControlException{
        Optional<GeoCache> geoCacheOptional = geoCacheRepository.findById(id);

        if(!geoCacheOptional.isPresent())
            throw new IllegalArgumentException("There is no Geocache with id: " + id);

        ApplicationUser applicationUser = currentUserService.getCurrentUserFromSecurityContext();

        GeoCache geoCacheFromDb = geoCacheOptional.get();

        if(geoCacheFromDb.getCreator().getId() != applicationUser.getId())
            throw new AccessControlException("Current user does not have acces to this geocache");

        geoCacheRepository.deleteById(id);
    }

    public void addVisitorToGeoCache(Long geoId) throws IllegalArgumentException{
        Optional<GeoCache> geoCacheOptional = geoCacheRepository.findById(geoId);

        if(!geoCacheOptional.isPresent())
            throw new IllegalArgumentException("There is no Geocache with id: " + geoId);

        ApplicationUser applicationUser = currentUserService.getCurrentUserFromSecurityContext();

        GeoCache geoCacheFromDb = geoCacheOptional.get();

        geoCacheFromDb.getVisitors().add(applicationUser);
    }

}
