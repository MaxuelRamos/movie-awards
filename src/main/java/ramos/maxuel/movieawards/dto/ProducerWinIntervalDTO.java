package ramos.maxuel.movieawards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerWinIntervalDTO {

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

}
