package map.project.demo.buchFactory;


import map.project.demo.model.Buch;

public interface BuchFactory {

    Buch createBuch(java.lang.Long idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis);

}

