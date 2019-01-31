package com.pm.GeoCachePortalV2Api.Models.BlogPost;

import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Models.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "geo_cache")
public class BlogPost extends AuditModel {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "blogpost_generator")
    @SequenceGenerator(
            name = "blogpost_generator",
            sequenceName = "blogpost_sequence",
            initialValue = 1000
    )
    private Long id;

    @Getter
    @Setter
    @Column(name = "text_contents")
    String textContents;

    @Getter
    @Setter
    @ManyToOne
    ApplicationUser creator;

}



