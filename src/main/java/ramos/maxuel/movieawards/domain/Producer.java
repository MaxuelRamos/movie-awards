package ramos.maxuel.movieawards.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "Producer")
public class Producer {

    public Producer(String name) {
        this.name = name.trim();
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "producers", fetch = FetchType.LAZY)
    Set<Movie> movies;

}
