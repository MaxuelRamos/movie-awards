package ramos.maxuel.movieawards.mappers;

import org.mapstruct.Mapper;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;
import ramos.maxuel.movieawards.dto.EntityMapper;
import ramos.maxuel.movieawards.dto.ProducerWinIntervalDTO;

@Mapper(componentModel = "spring")
public interface ProducerWinIntervalMapper extends EntityMapper<ProducerWinIntervalDTO, ProducerWinInterval> {
}
