package ramos.maxuel.movieawards.mappers;

import org.mapstruct.Mapper;
import ramos.maxuel.movieawards.domain.MinAndMaxProducerWinInterval;
import ramos.maxuel.movieawards.dto.EntityMapper;
import ramos.maxuel.movieawards.dto.MinAndMaxProducerWinIntervalDTO;

@Mapper(componentModel = "spring")
public interface MinAndMaxProducerWinIntervalMapper extends EntityMapper<MinAndMaxProducerWinIntervalDTO, MinAndMaxProducerWinInterval> {
}
