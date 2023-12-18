package map.project.demo.BuchFactory;


import map.project.demo.model.Buch;

public interface BuchFactory {

    Buch createBuch(Long idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis);

}

