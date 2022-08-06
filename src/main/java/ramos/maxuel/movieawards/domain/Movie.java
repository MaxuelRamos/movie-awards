package ramos.maxuel.movieawards.domain;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "[year]")
    private String year;

    @Column
    private String title;

    @Column
    private String studios;

    @Column
    private String producers;

    @Column
    private String winner;
}
