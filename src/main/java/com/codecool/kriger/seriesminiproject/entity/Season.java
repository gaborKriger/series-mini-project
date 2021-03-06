package com.codecool.kriger.seriesminiproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {


    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer seasonNumber;

    @ManyToOne
    private Series series;

    @Singular
    @OneToMany(mappedBy = "season",
            cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    private Set<Episode> episodes;

    public Season(Integer seasonNumber,
                  Series series) {
        this.seasonNumber = seasonNumber;
        this.series = series;
    }
}
