package map.project.demo.model;

import jakarta.persistence.*;
import map.project.demo.repository.Identifiable;

import java.util.Date;

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

//    @OneToOne(mappedBy = "kunde")
//    private Konto konto;

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

    public Long getIdAngestellte() {
        return idAngestellte;
    }

    public void setIdAngestellte(Long angestellte) {
        this.idAngestellte = idAngestellte;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public int getGehalt() {
        return gehalt;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public Long getId() {
        return null;
    }
}
