package ramos.maxuel.movieawards.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "Producer_win_interval")
public class ProducerWinInterval {

    @Id
    @Column
    private String producer;

    @Column(name = "win_interval")
    private int interval;

    @Column
    private int previousWin;

    @Column
    private int followingWin;

    @Column
    private int rankNumber;

}
