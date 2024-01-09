package map.project.demo.buchFactory;


import map.project.demo.model.Buch;

public class RomanceBuchFactory implements  BuchFactory {

    @Override
    public Buch createBuch(Long idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis) {
        return new Buch(idBuch, title, autor, "Romance", anzahlSeiten, erstellungsjahr, preis);
    }
}
