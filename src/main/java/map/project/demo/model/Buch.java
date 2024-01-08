package map.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.util.ArrayList;
import java.util.List;

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
    private Float preis;

    //    @OneToMany(mappedBy = "buch")
////    @JoinColumn(name = "id_review")
//    private List<Review> reviewsList;
    @OneToMany(mappedBy = "buch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewsList = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "listeBucherInBestellung")
    private List<Bestellung> bucherInBestellung = new ArrayList();

    @JsonIgnore
    @ManyToMany(mappedBy = "listeBucherInWishlist")
    private List<Wishlist> bucherInWishlist = new ArrayList();

    public Buch(Long idBuch, String title, String autor, String genre, Integer anzahlSeiten, Integer erstellungsjahr, Float preis) {
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
