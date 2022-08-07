package ramos.maxuel.movieawards.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ramos.maxuel.movieawards.dto.ResponseMessageDTO;
import ramos.maxuel.movieawards.services.MovieService;
import ramos.maxuel.movieawards.utils.CSVUtils;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<ResponseMessageDTO> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        if (CSVUtils.hasCSVFormat(file)) {
            try {
                movieService.createFromFile(file);
                message = "Movies creation in progress...";
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageDTO(message));
            } catch (Exception e) {
                message = "Could not extract movies from the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageDTO(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageDTO(message));
    }
}
