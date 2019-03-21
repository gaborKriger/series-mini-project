package com.codecool.kriger.seriesminiproject.repository;

import com.codecool.kriger.seriesminiproject.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
