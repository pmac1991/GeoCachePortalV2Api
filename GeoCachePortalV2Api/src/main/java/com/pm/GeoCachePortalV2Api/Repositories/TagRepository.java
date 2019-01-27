package com.pm.GeoCachePortalV2Api.Repositories;

import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
