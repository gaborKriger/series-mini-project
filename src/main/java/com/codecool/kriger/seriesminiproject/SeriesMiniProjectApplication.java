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
            Series gameOfThrones = setSeries("Game of Thrones",
                    "Game of Thrones is the immensely popular television show that has aired for four seasons on HBO. The show is based on the epic fantasy novel series, A Song of Fire and Ice, written by George R. R. Martin. The first novel of the seven-book series is called A Game of Thrones; the show creators and HBO decided to keep that title as the overall name of the show.");

            Season gameOfThronesS1 = setSeason(gameOfThrones);

            Episode gameOfThronesS1E1 = setEpisode(gameOfThronesS1,
                    "Winter Is Comming",
                    Duration.ofMinutes(62),
                    LocalDate.of(2011, 4, 11),
                    "Jon Arryn, the Hand of the King, is dead. King Robert Baratheon plans to ask his oldest friend, Eddard Stark, to take Jon's place. Across the sea, Viserys Targaryen plans to wed his sister to a nomadic warlord in exchange for an army.");

            Episode gameOfThronesS1E2 = setEpisode(gameOfThronesS1,
                    "The Kingsroad",
                    Duration.ofMinutes(56),
                    LocalDate.of(2011, 4, 24),
                    "While Bran recovers from his fall, Ned takes only his daughters to King's Landing. Jon Snow goes with his uncle Benjen to the Wall. Tyrion joins them.");

            Episode gameOfThronesS1E3 = setEpisode(gameOfThronesS1,
                    "Lord Snow",
                    Duration.ofMinutes(58),
                    LocalDate.of(2011, 5, 1),
                    "Lord Stark and his daughters arrive at King's Landing to discover the intrigues of the king's realm.");

            Episode gameOfThronesS1E4 = setEpisode(gameOfThronesS1,
                    "Cripples, Bastards, and Broken Things",
                    Duration.ofMinutes(56),
                    LocalDate.of(2011, 5, 8),
                    "Eddard investigates Jon Arryn's murder. Jon befriends Samwell Tarly, a coward who has come to join the Night's Watch.");

            seriesRepository.save(gameOfThrones);
            seasonRepository.save(gameOfThronesS1);
            episodeRepository.save(gameOfThronesS1E1);
            episodeRepository.save(gameOfThronesS1E2);
            episodeRepository.save(gameOfThronesS1E3);
            episodeRepository.save(gameOfThronesS1E4);
        };
    }

    private Series setSeries(String title, String description) {
        return Series.builder()
                .title(title)
                .description(description)
                .build();
    }

    private Season setSeason(Series series) {
        return Season.builder()
                .seasonNumber(1)
                .series(series)
                .build();
    }

    private Episode setEpisode(Season season, String title, Duration length, LocalDate date, String description) {
        return Episode.builder()
                .title(title)
                .description(description)
                .length(length)
                .releaseDate(date)
                .season(season)
                .build();
    }

}
