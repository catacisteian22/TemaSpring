package map.project.demo.BuchFactory;

import map.project.demo.model.Buch;

public class YABuchFactory implements BuchFactory {

    @Override
    public Buch createBuch(Long idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis) {
        return new Buch(idBuch, title, autor, "YA", anzahlSeiten, erstellungsjahr, preis);
    }

}