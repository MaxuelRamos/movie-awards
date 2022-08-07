package ramos.maxuel.movieawards.controllers

import org.springframework.beans.factory.annotation.Autowired
import ramos.maxuel.movieawards.BaseIntegrationTest
import ramos.maxuel.movieawards.domain.Movie
import ramos.maxuel.movieawards.domain.Producer
import ramos.maxuel.movieawards.dto.MinAndMaxProducerWinIntervalDTO
import ramos.maxuel.movieawards.repositories.MovieRepository
import ramos.maxuel.movieawards.repositories.ProducerRepository

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ProducerWinIntervalControllerTest extends BaseIntegrationTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ProducerRepository producerRepository;

    def "GET to /api/producers-win-interval/min-and-max returns proper result when data is present in the database"() {
        given:
        'dataIsSetup()'()

        when:
        def mvcResult = mvc.perform(get('/api/producers-win-interval/min-and-max'))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()

        String content = mvcResult.getResponse().getContentAsString();
        MinAndMaxProducerWinIntervalDTO result = objectMapper.readValue(content, MinAndMaxProducerWinIntervalDTO.class);

        then:
        result
        result.min
        result.min.size() == 1
        result.min[0].producer == 'Producer 4'
        result.min[0].interval == 1
        result.min[0].previousWin == 2007
        result.min[0].followingWin == 2008

        result.max
        result.max.size() == 1
        result.max[0].producer == 'Producer'
        result.max[0].interval == 10
        result.max[0].previousWin == 2000
        result.max[0].followingWin == 2010
    }

    def 'dataIsSetup()'() {
        Producer p1 = new Producer('Producer')
        Producer p2 = new Producer('Producer')

        // Control data
        Producer p3 = new Producer('Producer 3')
        Producer p4 = new Producer('Producer 4')

        producerRepository.saveAll([p1, p2, p3, p4])

        Movie m1 = new Movie(null, 2000, 'Movie', 'Studio', '', true, Set.of(p1))
        Movie m2 = new Movie(null, 2010, 'Movie', 'Studio', '', true, Set.of(p1))

        Movie m3 = new Movie(null, 2001, 'Movie', 'Studio', '', true, Set.of(p2))
        Movie m4 = new Movie(null, 2005, 'Movie', 'Studio', '', true, Set.of(p2))

        Movie m5 = new Movie(null, 2006, 'Movie', 'Studio', '', true, Set.of(p3))
        Movie m6 = new Movie(null, 2009, 'Movie', 'Studio', '', true, Set.of(p3))

        Movie m7 = new Movie(null, 2007, 'Movie', 'Studio', '', true, Set.of(p4))
        Movie m8 = new Movie(null, 2008, 'Movie', 'Studio', '', true, Set.of(p4))
        
        // Control data
        Movie m9 = new Movie(null, 2011, 'Movie', 'Studio', '', false, Set.of(p1))
        Movie m10 = new Movie(null, 2012, 'Movie', 'Studio', '', false, Set.of(p1))

        Movie m11 = new Movie(null, 2013, 'Movie', 'Studio', '', false, Set.of(p2))
        Movie m12 = new Movie(null, 2014, 'Movie', 'Studio', '', false, Set.of(p2))

        Movie m13 = new Movie(null, 2015, 'Movie', 'Studio', '', false, Set.of(p3))
        Movie m14 = new Movie(null, 2016, 'Movie', 'Studio', '', false, Set.of(p3))

        Movie m15 = new Movie(null, 2017, 'Movie', 'Studio', '', false, Set.of(p4))
        Movie m16 = new Movie(null, 2018, 'Movie', 'Studio', '', false, Set.of(p4))

        movieRepository.saveAll([
                m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16
        ])
    }
}