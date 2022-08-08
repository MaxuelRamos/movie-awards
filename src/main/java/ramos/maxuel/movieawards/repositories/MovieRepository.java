package ramos.maxuel.movieawards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ramos.maxuel.movieawards.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
