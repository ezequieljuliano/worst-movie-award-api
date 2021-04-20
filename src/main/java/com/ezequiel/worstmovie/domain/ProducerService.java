package com.ezequiel.worstmovie.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerService {

    private static final Integer AWARDS_MIN_QUANTITY = 2;

    private final MovieRepository movieRepository;

    public AwardInterval getIntervalAwards() {
        List<Movie> winningMovies = movieRepository.findByWinner(true);
        Map<String, List<Movie>> moviesByProducer = winningMovies.stream().collect(Collectors.groupingBy(Movie::getProducer));

        List<ProducerInterval> intervals = new ArrayList<>();

        moviesByProducer.forEach((producer, movies) -> {
            movies.sort(Comparator.comparing(Movie::getYear));
            if (movies.size() >= AWARDS_MIN_QUANTITY) {
                movies.forEach(movie -> {
                    Movie nextMovie = getNextMovie(movies, movie);
                    if (nextMovie != null) {
                        ProducerInterval interval = new ProducerInterval();
                        interval.setProducer(producer);
                        interval.setPreviousWin(movie.getYear());
                        interval.setFollowingWin(nextMovie.getYear());
                        interval.setInterval(interval.getFollowingWin() - interval.getPreviousWin());
                        intervals.add(interval);
                    }
                });
            }
        });

        List<ProducerInterval> minInterval = intervals.stream().filter(
                producerInterval -> producerInterval.getInterval().equals(
                        intervals.stream()
                                .min(Comparator.comparing(ProducerInterval::getInterval))
                                .orElseThrow(NoSuchElementException::new).getInterval()
                )
        ).collect(Collectors.toList());

        List<ProducerInterval> maxInterval = intervals.stream().filter(
                producerInterval -> producerInterval.getInterval().equals(
                        intervals.stream()
                                .max(Comparator.comparing(ProducerInterval::getInterval))
                                .orElseThrow(NoSuchElementException::new).getInterval()
                )
        ).collect(Collectors.toList());

        return new AwardInterval(minInterval, maxInterval);
    }

    private Movie getNextMovie(List<Movie> winningMovies, Movie currentMovie) {
        int index = winningMovies.indexOf(currentMovie);
        if (index < 0 || index + 1 == winningMovies.size()) {
            return null;
        }
        return winningMovies.get(index + 1);
    }

}
