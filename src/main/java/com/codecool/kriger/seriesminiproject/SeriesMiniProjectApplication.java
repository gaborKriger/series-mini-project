package com.codecool.kriger.seriesminiproject;

import com.codecool.kriger.seriesminiproject.entity.Episode;
import com.codecool.kriger.seriesminiproject.entity.Season;
import com.codecool.kriger.seriesminiproject.entity.Series;
import com.codecool.kriger.seriesminiproject.repository.EpisodeRepository;
import com.codecool.kriger.seriesminiproject.repository.SeasonRepository;
import com.codecool.kriger.seriesminiproject.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.Duration;
import java.time.LocalDate;

@SpringBootApplication
public class SeriesMiniProjectApplication {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesMiniProjectApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Series gameOfThrones = setSeries("Game of Thrones");

            Season gameOfThronesS1 = setSeason(gameOfThrones);

            Episode gameOfThronesS1E1 = setEpisode(gameOfThronesS1,
                    "Winter Is Comming",
                    Duration.ofMinutes(62),
                    LocalDate.of(2011,4,11));

            Episode gameOfThronesS1E2 = setEpisode(gameOfThronesS1,
                    "The Kingsroad",
                    Duration.ofMinutes(56),
                    LocalDate.of(2011,4,24));

            Episode gameOfThronesS1E3 = setEpisode(gameOfThronesS1,
                    "Lord Snow",
                    Duration.ofMinutes(58),
                    LocalDate.of(2011,5,1));

            Episode gameOfThronesS1E4 = setEpisode(gameOfThronesS1,
                    "Cripples, Bastards, and Broken Things",
                    Duration.ofMinutes(56),
                    LocalDate.of(2011,5,8));

            seriesRepository.save(gameOfThrones);
            seasonRepository.save(gameOfThronesS1);
            episodeRepository.save(gameOfThronesS1E1);
            episodeRepository.save(gameOfThronesS1E2);
            episodeRepository.save(gameOfThronesS1E3);
            episodeRepository.save(gameOfThronesS1E4);
        };
    }

    private Series setSeries(String title) {
        return Series.builder()
                        .title(title)
                        .build();
    }

    private Season setSeason(Series series) {
        return Season.builder()
                .seasonNumber(1)
                .series(series)
                .build();
    }

    private Episode setEpisode(Season season, String title, Duration length, LocalDate date) {
        return Episode.builder()
                .title(title)
                .length(length)
                .releaseDate(date)
                .season(season)
                .build();
    }

}
