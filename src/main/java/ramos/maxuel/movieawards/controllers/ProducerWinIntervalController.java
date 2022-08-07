package ramos.maxuel.movieawards.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ramos.maxuel.movieawards.domain.MinAndMaxProducerWinInterval;
import ramos.maxuel.movieawards.dto.MinAndMaxProducerWinIntervalDTO;
import ramos.maxuel.movieawards.mappers.MinAndMaxProducerWinIntervalMapper;
import ramos.maxuel.movieawards.services.ProducerWinIntervalService;

@RestController
@RequestMapping("/api/producers-win-interval")
@RequiredArgsConstructor
public class ProducerWinIntervalController {

    private final ProducerWinIntervalService service;
    private final MinAndMaxProducerWinIntervalMapper mapper;

    @GetMapping("/min-and-max")
    public MinAndMaxProducerWinIntervalDTO findMinAndMaxProducerWin() {
        MinAndMaxProducerWinInterval minAndMaxProducersWinInterval = service.findMaxAndMinProducerWin();
        return mapper.toDto(minAndMaxProducersWinInterval);
    }
}
