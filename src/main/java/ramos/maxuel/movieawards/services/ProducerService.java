package ramos.maxuel.movieawards.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;
import ramos.maxuel.movieawards.repositories.MovieRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final MovieRepository movieRepository;

    public List<ProducerWinInterval> findMaxAndMinProducerWin() {
        movieRepository.findAll();

        return Collections.singletonList(new ProducerWinInterval("test", 1, 2, 3));
    }
}
