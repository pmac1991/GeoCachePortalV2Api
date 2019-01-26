package com.pm.GeoCachePortalV2Api.Repositories;

import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoCacheRepository extends JpaRepository<GeoCache, Long> {
}
