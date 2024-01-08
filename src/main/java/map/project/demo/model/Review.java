package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

@Data
@Entity
@Table(name = "review")
public class Review implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReview;

    private String text;
    private int anzahlSternchen;

    //    @ManyToOne(cascade =  CascadeType.ALL)
//    @JoinColumn(name= "buch_ID", referencedColumnName = "idReview")//foreign key in table Review
//    private Buch buch;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buch_ID")  // The foreign key in the Review table
    private Buch buch;

    public Review(Long idReview, String text, int anzahlSternchen) {
    }

    public Review() {

    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public Long getId() {
        return idReview;
    }
}