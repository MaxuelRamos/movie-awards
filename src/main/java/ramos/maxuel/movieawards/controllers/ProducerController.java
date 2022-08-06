package ramos.maxuel.movieawards.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;
import ramos.maxuel.movieawards.dto.ProducerWinIntervalDTO;
import ramos.maxuel.movieawards.mappers.ProducerWinIntervalMapper;
import ramos.maxuel.movieawards.services.ProducerService;

import java.util.List;

@RestController
@RequestMapping("/api/producers")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;
    private final ProducerWinIntervalMapper producerWinIntervalMapper;

    @GetMapping("/win-interval")
    public List<ProducerWinIntervalDTO> findMaxAndMinProducerWin() {
        List<ProducerWinInterval> producers = producerService.findMaxAndMinProducerWin();

        return producerWinIntervalMapper.toDto(producers);
    }
}
