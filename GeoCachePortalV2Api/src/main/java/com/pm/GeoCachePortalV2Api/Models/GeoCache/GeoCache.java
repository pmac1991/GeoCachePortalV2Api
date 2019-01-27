package com.pm.GeoCachePortalV2Api.Models.GeoCache;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Models.AuditModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "geo_cache")
public class GeoCache extends AuditModel {

    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "geocache_generator")
    @SequenceGenerator(
            name = "geocache_generator",
            sequenceName = "geocache_sequence",
            initialValue = 1000
    )
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    String name;

    @Getter
    @Setter
    @Column(name = "geo_lat")
    String geoLat;

    @Getter
    @Setter
    @Column(name = "geo_long")
    String geoLong;

    @Getter
    @Setter
    @Column(name = "description")
    String description;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "geocache_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    List<Tag> tagList;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "geocache_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    List<ApplicationUser> visitors;

    @Getter
    @Setter
    @ManyToOne
    ApplicationUser creator;
}
