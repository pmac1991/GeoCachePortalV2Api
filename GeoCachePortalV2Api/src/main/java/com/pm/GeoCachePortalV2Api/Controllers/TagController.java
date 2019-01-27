package com.pm.GeoCachePortalV2Api.Controllers;

import com.pm.GeoCachePortalV2Api.Models.GeoCache.GeoCache;
import com.pm.GeoCachePortalV2Api.Models.GeoCache.Tag;
import com.pm.GeoCachePortalV2Api.Repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tags")
    public Page<Tag> getAllTags(Pageable pageable){
        return tagRepository.findAll(pageable);
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<Object> getTag(@PathVariable long id){
        Optional<Tag> foundTag = tagRepository.findById(id);
        if(!foundTag.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(foundTag.get());
    }


    @PostMapping("/tag")
    public Tag createTag(@Valid @RequestBody Tag tag){
        return tagRepository.save(tag);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTag(@PathVariable long id){
        Optional<Tag> foundTag = tagRepository.findById(id);
        if(!foundTag.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        tagRepository.delete(foundTag.get());
        return ResponseEntity.ok().build();
    }

}
