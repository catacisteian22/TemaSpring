package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "angestellte")
public class Angestellte implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAngestellte;

    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;
    private String rolle;
    private int gehalt;

    @OneToOne(mappedBy = "angestellte")
    private Konto konto;
    public Angestellte(Long idAngestellte, String name, String vorname, String email, Date geburtsDatum, String rolle, int gehalt) {
    }

    @Override
    public String toString() {
        return "Angestellte{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", email='" + email + '\'' +
                ", geburtsDatum=" + geburtsDatum +
                ", idAngestellte='" + idAngestellte + '\'' +
                ", rolle='" + rolle + '\'' +
                ", gehalt=" + gehalt +
                '}';
    }

    @Override
    public Long getId() {
        return null;
    }
}
