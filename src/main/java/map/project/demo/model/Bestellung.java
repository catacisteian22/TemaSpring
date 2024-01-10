package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "bestellung")
public class Bestellung implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBestellung;
    private LocalDateTime datum;
    private Float gesamtpreis;
    private String adresse;

    @ManyToMany
    private List<Buch> listeBucherInBestellung;

    public Bestellung(Long idBestellung, LocalDateTime datum, float gesamtpreis, String adresse) {
        this.idBestellung = idBestellung;
        this.datum = datum;
        this.gesamtpreis = gesamtpreis;
        this.adresse = adresse;
    }

    public Bestellung() {
    }

    @Override
    public Long getId() {
        return idBestellung;
    }


    private float calculateGesamtpreis(List<Buch> bucher) {
        float total = 0.0f;
        for (Buch buch : bucher) {
            total += buch.getPreis();
        }
        return total;
    }
}