package com.codecool.kriger.seriesminiproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;
    private String title;


    @Singular
    @OneToMany(mappedBy = "series",
            cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;
}
