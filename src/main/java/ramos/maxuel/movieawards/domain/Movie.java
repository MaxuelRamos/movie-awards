package ramos.maxuel.movieawards.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "Movie")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "[year]")
    private Integer year;

    @Column
    private String title;

    @Column
    private String studios;

    @Column
    private String producersStr;

    @Column
    private Boolean winner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "producer_has_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    private Set<Producer> producers;
}
