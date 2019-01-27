package com.pm.GeoCachePortalV2Api.Controllers;

import com.pm.GeoCachePortalV2Api.Models.GeoCache.DTO.GeoCacheCommonInfoDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.DTO.GeoCacheFullInfoDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Repositories.GeoCacheRepository;
import com.pm.GeoCachePortalV2Api.Services.GeoCacheService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.AccessControlException;
import java.util.List;

@RestController
public class GeoCacheController {

    @Autowired
    private GeoCacheRepository geoCacheRepository;

    @Autowired
    private GeoCacheService geoCacheService;

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

    @GetMapping("/userGeoCaches")
    public Page<GeoCacheFullInfoDTO> getGeaocachesForUser(Pageable pageable){

        Page<GeoCache> geoCachesForUser = geoCacheService.getGeoCachesForUser(pageable);
        Page<GeoCacheFullInfoDTO> fullInfoDTOS = geoCachesForUser.map(
                it -> modelMapper.map(it,GeoCacheFullInfoDTO.class)
        );
        return  fullInfoDTOS;
    }

    @PostMapping("/geoCache")
    public GeoCacheFullInfoDTO createGeoCache(@Valid @RequestBody GeoCache geoCache){
        return modelMapper.map(geoCacheService.saveGeoCacheForCurrentUser(geoCache),GeoCacheFullInfoDTO.class);
    }

    @PutMapping("/geoCache/{id}")
    public ResponseEntity<Object> updateGeoCahe(@RequestBody GeoCache cache, @PathVariable long id){
        try{
            geoCacheService.updateGeoCache(cache,id);
            return ResponseEntity.noContent().build();
        }catch (AccessControlException ace){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }catch (IllegalArgumentException iae){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/geoCache/{id}")
    public ResponseEntity<Object> deleteGeoCache(@PathVariable long id){
        try{
            geoCacheService.deleteGeoCache(id);
            return ResponseEntity.noContent().build();
        }catch (AccessControlException ace){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }catch (IllegalArgumentException iae){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/geoCache/{geoId}/addVisitor")
    public ResponseEntity<Object> addVisitorToGeoCache(@PathVariable long geoId){
        try{
            geoCacheService.addVisitorToGeoCache(geoId);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException iae){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
