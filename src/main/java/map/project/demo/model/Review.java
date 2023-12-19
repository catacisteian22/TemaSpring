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