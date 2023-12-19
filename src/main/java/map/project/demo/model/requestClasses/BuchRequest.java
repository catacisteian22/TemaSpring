package map.project.demo.model.requestClasses;

import lombok.Data;

@Data
public class BuchRequest {
    private Long idBuch;
    private String title;
    private String autor;
    private String genre;
    private Integer anzahlSeiten;
    private Integer erstellungsjahr;
    private Float preis;
}