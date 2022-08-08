package ramos.maxuel.movieawards.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "Producer_win_interval")
@IdClass(ProducerWinIntervalCompositeKey.class)
public class ProducerWinInterval {

    @Id
    @Column
    private String producer;

    @Column(name = "win_interval")
    private int interval;

    @Id
    @Column
    private int previousWin;

    @Column
    private int followingWin;

    @Column
    private int rankNumber;

}
