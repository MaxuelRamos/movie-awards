package ramos.maxuel.movieawards.components.importers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ramos.maxuel.movieawards.services.MovieService;

import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class CSVToMovieImporter {

    @Autowired
    private final MovieService movieService;

    public void importMovies() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("movielist.csv");
        movieService.createFromBytes(stream);
    }
}
