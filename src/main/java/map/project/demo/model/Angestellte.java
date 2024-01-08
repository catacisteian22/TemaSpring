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
    private Integer gehalt;

    @OneToOne(mappedBy = "angestellte")
    private Konto konto;

    public Angestellte(Long idAngestellte, String name, String vorname, String email, Date geburtsDatum, String rolle, Integer gehalt) {
        this.idAngestellte = idAngestellte;
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.geburtsDatum = geburtsDatum;
        this.rolle = rolle;
        this.gehalt = gehalt;
    }

//    public Angestellte(Long idAngestellte, String name, String vorname, String email, Date geburtsDatum, String rolle, Integer gehalt) {
//    }

    public Angestellte() {

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
