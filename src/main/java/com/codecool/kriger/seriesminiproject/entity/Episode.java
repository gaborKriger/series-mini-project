package com.codecool.kriger.seriesminiproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    private Duration length;
    private LocalDate releaseDate;

    @ManyToOne
    private Season season;

    public Episode(String title,
                   Duration length,
                   LocalDate releaseDate,
                   Season season) {
        this.title = title;
        this.length = length;
        this.releaseDate = releaseDate;
        this.season = season;
    }
}
