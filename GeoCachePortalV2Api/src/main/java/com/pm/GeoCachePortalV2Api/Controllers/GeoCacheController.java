package com.pm.GeoCachePortalV2Api.Controllers;

import com.pm.GeoCachePortalV2Api.Models.GeoCache.DTO.GeoCacheCommonInfoDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Repositories.GeoCacheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GeoCacheController {

    @Autowired
    private GeoCacheRepository geoCacheRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/geoCaches")
    public Page<GeoCacheCommonInfoDTO> getGeoCaches(Pageable pageable){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<GeoCache> fullGeocacheList = geoCacheRepository.findAll(pageable);
        Page<GeoCacheCommonInfoDTO> commonInfoDTOS = fullGeocacheList.map(
                it -> modelMapper.map(it,GeoCacheCommonInfoDTO.class)
        );

        return commonInfoDTOS;
    }

    @PostMapping("/geoCache")
    public GeoCache createGeoCache(@Valid @RequestBody GeoCache geoCache){
        return geoCacheRepository.save(geoCache);
    }

}
