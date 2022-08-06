package ramos.maxuel.movieawards.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProducerWinInterval {

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

}
