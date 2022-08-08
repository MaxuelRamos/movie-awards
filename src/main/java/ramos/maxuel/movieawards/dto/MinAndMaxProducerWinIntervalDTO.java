package ramos.maxuel.movieawards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinAndMaxProducerWinIntervalDTO {

    private List<ProducerWinIntervalDTO> min;
    private List<ProducerWinIntervalDTO> max;

}
