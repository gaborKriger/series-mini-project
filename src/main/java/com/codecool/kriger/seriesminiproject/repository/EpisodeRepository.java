package com.codecool.kriger.seriesminiproject.repository;

import com.codecool.kriger.seriesminiproject.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
