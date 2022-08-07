package ramos.maxuel.movieawards.parsers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ramos.maxuel.movieawards.domain.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CSVToMovieParser {

//    static String[] HEADERs = {"year", "title", "studios", "producers", "winner"};

    public List<Movie> parse(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';'))) {

            List<CSVRecord> csvRecords = csvParser.getRecords();

            return csvRecords.parallelStream()
                    .map(this::parseCSVToMovie)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    private Movie parseCSVToMovie(CSVRecord csvRecord) {
        String yearStr = csvRecord.get("year");
        String winnerStr = csvRecord.get("winner");

        return Movie.builder()
                .year(Integer.valueOf(yearStr))
                .title(csvRecord.get("title"))
                .studios(csvRecord.get("studios"))
                .producersStr(csvRecord.get("producers"))
                .winner(Boolean.parseBoolean(winnerStr))
                .producers(new HashSet<>())
                .build();
    }
}
