package com.ezequiel.worstmovie.infrastructure;

import com.ezequiel.worstmovie.domain.MovieDataReader;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.logging.log4j.util.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MovieCsvFileAdapter implements MovieDataReader {

    private static final String COMMA_DELIMITER = ";";
    private static final String SKIP_TEXT = "year";
    private static final Integer YEAR_INDEX = 0;
    private static final Integer TITLE_INDEX = 1;
    private static final Integer STUDIOS_INDEX = 2;
    private static final Integer PRODUCERS_INDEX = 3;
    private static final Integer WINNER_INDEX = 4;

    private final File csvFile;

    @Override
    public List<MovieProperties> execute() {
        List<MovieProperties> movies = new ArrayList<>();
        fetchRecords().forEach(values -> {
            String[] producers = values[PRODUCERS_INDEX].split("(and|,)");
            for (String producer : producers) {
                if (!Strings.isBlank(producer)) {
                    MovieProperties movie = new MovieProperties();
                    movie.setYear(Long.valueOf(values[YEAR_INDEX]));
                    movie.setTitle(values[TITLE_INDEX].trim());
                    movie.setStudio(values[STUDIOS_INDEX].trim());
                    movie.setWinner(false);
                    if (values.length > 4 && values[WINNER_INDEX] != null) {
                        movie.setWinner(values[WINNER_INDEX].equalsIgnoreCase("yes"));
                    }
                    movie.setProducer(producer.trim());
                    movies.add(movie);
                }
            }
        });
        return movies;
    }

    @SneakyThrows
    private List<String[]> fetchRecords() {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                if (!values[YEAR_INDEX].equalsIgnoreCase(SKIP_TEXT)) {
                    records.add(values);
                }
            }
        }
        return records;
    }

}
