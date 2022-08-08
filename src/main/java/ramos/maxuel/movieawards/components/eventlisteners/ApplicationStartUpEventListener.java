package ramos.maxuel.movieawards.components.eventlisteners;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ramos.maxuel.movieawards.components.importers.CSVToMovieImporter;

@Component
@RequiredArgsConstructor
public class ApplicationStartUpEventListener {

    @Value("${application.features.auto-import:true}")
    private boolean autoImportEnabled;

    @Autowired
    private final CSVToMovieImporter csvToMovieImporter;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        if (autoImportEnabled) {
            csvToMovieImporter.importMovies();
        }
    }
}
