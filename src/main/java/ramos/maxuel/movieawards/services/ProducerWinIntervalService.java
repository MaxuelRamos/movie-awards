package ramos.maxuel.movieawards.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ramos.maxuel.movieawards.domain.MinAndMaxProducerWinInterval;
import ramos.maxuel.movieawards.domain.Producer;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;
import ramos.maxuel.movieawards.repositories.ProducerRepository;
import ramos.maxuel.movieawards.repositories.ProducerWinIntervalRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProducerWinIntervalService {

    private final ProducerWinIntervalRepository producerRepository;

    public MinAndMaxProducerWinInterval findMaxAndMinProducerWin() {
        List<ProducerWinInterval> minInterval = producerRepository.findMinWinInterval();
        List<ProducerWinInterval> maxInterval = producerRepository.findMaxWinInterval();

        return new MinAndMaxProducerWinInterval(minInterval, maxInterval);
    }

}
