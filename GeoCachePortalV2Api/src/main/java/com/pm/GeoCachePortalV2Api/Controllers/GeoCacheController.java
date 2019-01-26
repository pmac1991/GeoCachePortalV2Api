package com.pm.GeoCachePortalV2Api.Controllers;

import com.pm.GeoCachePortalV2Api.Models.GeoCache;
import com.pm.GeoCachePortalV2Api.Repositories.GeoCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.validation.Valid;

@RestController
public class GeoCacheController {

    @Autowired
    private GeoCacheRepository geoCacheRepository;

    @GetMapping("/geoCaches")
    public Page<GeoCache> getGeoCaches(Pageable pageable){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return geoCacheRepository.findAll(pageable);
    }

    @PostMapping("/geoCache")
    public GeoCache createGeoCache(@Valid @RequestBody GeoCache geoCache){
        return geoCacheRepository.save(geoCache);
    }

}
