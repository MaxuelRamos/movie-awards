package ramos.maxuel.movieawards.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ramos.maxuel.movieawards.domain.Producer;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;
import ramos.maxuel.movieawards.repositories.MovieRepository;
import ramos.maxuel.movieawards.repositories.ProducerRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepository producerRepository;

    public List<Producer> saveAll(Set<String> producersStr) {
        Set<Producer> producers = producersStr.stream().map(Producer::new).collect(Collectors.toSet());
        return producerRepository.saveAll(producers);
    }
}
