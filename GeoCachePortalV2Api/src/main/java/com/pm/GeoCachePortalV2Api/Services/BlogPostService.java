package com.pm.GeoCachePortalV2Api.Services;

import com.pm.GeoCachePortalV2Api.Models.BlogPost.BlogPost;
import com.pm.GeoCachePortalV2Api.Repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private CurrentUserService currentUserService;

    public BlogPost saveBlogPostForCurrentUser(BlogPost blogPost){
        blogPost.setCreator(currentUserService.getCurrentUserFromSecurityContext());
        return blogPostRepository.save(blogPost);
    }
}


