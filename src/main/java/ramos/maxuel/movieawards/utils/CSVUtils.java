package ramos.maxuel.movieawards.utils;

import org.springframework.web.multipart.MultipartFile;

public class CSVUtils {

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }
}