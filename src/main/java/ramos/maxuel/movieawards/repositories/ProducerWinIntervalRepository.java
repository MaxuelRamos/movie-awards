package ramos.maxuel.movieawards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ramos.maxuel.movieawards.domain.Producer;
import ramos.maxuel.movieawards.domain.ProducerWinInterval;

import java.util.List;

@Repository
public interface ProducerWinIntervalRepository extends JpaRepository<ProducerWinInterval, String> {

    @Query("Select p from ProducerWinInterval p where rankNumber = 1")
    List<ProducerWinInterval> findMaxWinInterval();

    @Query("Select p from ProducerWinInterval p where rankNumber = (select max(p2.rankNumber) from ProducerWinInterval p2)")
    List<ProducerWinInterval> findMinWinInterval();

}
