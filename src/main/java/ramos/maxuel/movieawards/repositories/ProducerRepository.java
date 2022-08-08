package ramos.maxuel.movieawards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ramos.maxuel.movieawards.domain.Movie;
import ramos.maxuel.movieawards.domain.Producer;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;

import java.util.List;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {


}
