package com.pm.GeoCachePortalV2Api.Controllers;

import com.pm.GeoCachePortalV2Api.Models.BlogPost.BlogPost;
import com.pm.GeoCachePortalV2Api.Models.BlogPost.DTO.BlogPostDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.DTO.GeoCacheCommonInfoDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.DTO.GeoCacheFullInfoDTO;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Repositories.BlogPostRepository;
import com.pm.GeoCachePortalV2Api.Services.BlogPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BlogPostController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blogPosts")
    public Page<BlogPostDTO> getBlogPosts(Pageable pageable){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<BlogPost> fullBlogPostsList = blogPostRepository.findAll(pageable);
        Page<BlogPostDTO> blogPostDTOS = fullBlogPostsList.map(
                it -> modelMapper.map(it,BlogPostDTO.class)
        );

        return blogPostDTOS;
    }

    @PostMapping("/blogPosts")
    public BlogPostDTO createBlogPost(@Valid @RequestBody BlogPost blogPost){
        return modelMapper.map(blogPostService.saveBlogPostForCurrentUser(blogPost), BlogPostDTO.class);
    }


}
