package map.project.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReview;
    private String text;
    private int anzahlSternchen;

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                '}';
    }

    public int getAnzahlSternchen() {
        return anzahlSternchen;
    }

    public void setAnzahlSternchen(int anzahlSternchen) {
        this.anzahlSternchen = anzahlSternchen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }

}