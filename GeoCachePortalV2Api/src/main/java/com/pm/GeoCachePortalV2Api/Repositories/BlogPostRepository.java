package com.pm.GeoCachePortalV2Api.Repositories;

import com.pm.GeoCachePortalV2Api.Models.BlogPost.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
