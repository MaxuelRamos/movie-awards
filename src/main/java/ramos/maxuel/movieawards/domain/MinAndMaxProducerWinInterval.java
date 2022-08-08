package ramos.maxuel.movieawards.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinAndMaxProducerWinInterval {

   private List<ProducerWinInterval> min;
   private List<ProducerWinInterval> max;

}
