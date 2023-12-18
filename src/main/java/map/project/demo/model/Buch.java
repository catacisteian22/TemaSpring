package map.project.demo.model;

import com.example.temaj.repository.Identifiable;
import jakarta.persistence.*;

@Entity
@Table(name = "buch")
public class Buch implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBuch;
    private String title;
    private String autor;
    private String genre;
    private int anzahlSeiten;
    private int erstellungsjahr;
    private float preis;

    @ManyToOne
    @JoinColumn(name = "idBestellung")
    private Bestellung bestellung;

    public Buch(Long idBuch, String title, String autor, String genre, int anzahlSeiten, int erstellungsjahr, float preis) {
        this.idBuch = idBuch;
        this.title = title;
        this.autor = autor;
        this.genre = genre;
        this.anzahlSeiten = anzahlSeiten;
        this.erstellungsjahr = erstellungsjahr;
        this.preis = preis;
    }

    public Buch() {

    }

    @Override
    public String toString() {
        return "Buch{" +
                "idProdukt=" + idBuch +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", genre='" + genre + '\'' +
                ", anzahlSeiten=" + anzahlSeiten +
                ", erstellungsjahr=" + erstellungsjahr +
                ", preis=" + preis +
                '}';
    }

    //
    public Long getIdBuch() {
        return idBuch;
    }

    @Override
    public Long getId() {
        return idBuch;
    }

    public void setIdBuch(Long idBuch) {
        this.idBuch = idBuch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnzahlSeiten() {
        return anzahlSeiten;
    }

    public void setAnzahlSeiten(int anzahlSeiten) {
        this.anzahlSeiten = anzahlSeiten;
    }

    public int getErstellungsjahr() {
        return erstellungsjahr;
    }

    public void setErstellungsjahr(int erstellungsjahr) {
        this.erstellungsjahr = erstellungsjahr;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }
}
