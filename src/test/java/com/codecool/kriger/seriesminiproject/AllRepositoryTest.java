package com.codecool.kriger.seriesminiproject;

import com.codecool.kriger.seriesminiproject.entity.Episode;
import com.codecool.kriger.seriesminiproject.entity.Season;
import com.codecool.kriger.seriesminiproject.entity.Series;
import com.codecool.kriger.seriesminiproject.repository.EpisodeRepository;
import com.codecool.kriger.seriesminiproject.repository.SeasonRepository;
import com.codecool.kriger.seriesminiproject.repository.SeriesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    private Series gameOfThrones;
    private Season gameOfThrones_S01;
    private Episode gameOfThones_S01_E01;

    @Before
    public void init(){
        gameOfThrones = Series.builder()
                .title("Game of Throne")
                .build();

        gameOfThrones_S01 = Season.builder()
                .seasonNumber(1)
                .series(gameOfThrones)
                .build();

        gameOfThones_S01_E01 = Episode.builder()
                .title("Winter is comming")
                .length(62D)
                .releaseDate(LocalDate.of(2011,4,11))
                .season(gameOfThrones_S01)
                .build();
    }

    @Test
    public void saveOneSimpleSeries() {
        seriesRepository.save(gameOfThrones);
        List<Series> series = seriesRepository.findAll();
        assertThat(series).hasSize(1);
    }

    @Test
    public void saveOneSimpleSeason() {

    }

}
