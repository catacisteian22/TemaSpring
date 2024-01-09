package map.project.demo.buchFactory;


import map.project.demo.model.Buch;

public class ChemieBuchFactory implements BuchFactory {
    @Override
    public Buch createBuch(java.lang.Long idBuch, String title, String autor, int anzahlSeiten, int erstellungsjahr, float preis) {
        return new Buch(idBuch, title, autor, "Chemie", anzahlSeiten, erstellungsjahr, preis);
    }
}
