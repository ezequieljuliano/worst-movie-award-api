package com.ezequiel.worstmovie.infrastructure;

import com.ezequiel.worstmovie.domain.Movie;
import com.ezequiel.worstmovie.domain.MovieDataReader;
import com.ezequiel.worstmovie.domain.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieBootstrap implements ApplicationRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File csvFile = ResourceUtils.getFile("classpath:movielist.csv");
        MovieDataReader reader = new MovieCsvFileAdapter(csvFile);
        reader.execute().forEach(data -> {
            Movie movie = new Movie();
            movie.setYear(data.getYear());
            movie.setTitle(data.getTitle());
            movie.setStudio(data.getStudio());
            movie.setProducer(data.getProducer());
            movie.setWinner(data.getWinner());
            movieRepository.save(movie);
        });
    }

}
