package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

@Data
@Entity
@Table(name = "buch")
public class Buch implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBuch;

    private String title;
    private String autor;
    private String genre;
    private Integer anzahlSeiten;
    private Integer erstellungsjahr;
    private float preis;

    @ManyToOne
    @JoinColumn(name = "id_bestellung")
    private Bestellung bestellung;

    @ManyToOne
    @JoinColumn(name = "id_wishlist")
    private Wishlist wishlist;

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

    @Override
    public Long getId() {
        return idBuch;
    }
}
