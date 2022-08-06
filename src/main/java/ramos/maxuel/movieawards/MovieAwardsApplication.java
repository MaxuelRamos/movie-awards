package ramos.maxuel.movieawards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ramos.maxuel.movieawards.repositories.MovieRepository;

@SpringBootApplication
public class MovieAwardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAwardsApplication.class, args);
	}

}
