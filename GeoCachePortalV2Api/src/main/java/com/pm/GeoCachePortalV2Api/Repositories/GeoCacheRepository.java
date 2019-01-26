package com.pm.GeoCachePortalV2Api.Repositories;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoCacheRepository extends JpaRepository<GeoCache, Long> {

    public List<GeoCache> findByCreator(ApplicationUser creator);

}
