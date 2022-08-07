package ramos.maxuel.movieawards.services;

import com.google.common.base.Splitter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ramos.maxuel.movieawards.domain.Movie;
import ramos.maxuel.movieawards.domain.Producer;
import ramos.maxuel.movieawards.parsers.CSVToMovieParser;
import ramos.maxuel.movieawards.repositories.MovieRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MovieService {

    private static final Splitter PRODUCER_SPLITTER = Splitter.onPattern(", | and ");

    @Autowired
    private CSVToMovieParser csvToMovieParser;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void createFromFile(MultipartFile file) {
        try {
            List<Movie> movies = csvToMovieParser.parse(file.getInputStream());

            Map<String, Producer> producersByName = extractAndSaveProducers(movies);
            saveMovies(movies, producersByName);

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    private Map<String, Producer> extractAndSaveProducers(List<Movie> movies) {
        Set<String> producersStr = movies.parallelStream()
                .flatMap(this::splitProducersNames)
                .collect(Collectors.toSet());

        List<Producer> producers = producerService.saveAll(producersStr);

        return producers.stream()
                .collect(Collectors.toMap(Producer::getName, Function.identity()));
    }

    private Stream<String> splitProducersNames(Movie movie) {
        return PRODUCER_SPLITTER
                .splitToList(movie.getProducersStr().trim())
                .stream()
                .filter(t -> t.trim().length() > 0);
    }

    private void saveMovies(List<Movie> movies, Map<String, Producer> producers) {
        movies.forEach(m -> {
            List<String> movieProducers = PRODUCER_SPLITTER.splitToList(m.getProducersStr());
            movieProducers.forEach(p -> m.getProducers().add(producers.get(p)));
        });

        movieRepository.saveAll(movies);
    }
}
