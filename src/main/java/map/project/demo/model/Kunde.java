package map.project.demo.model;

import com.example.temaj.repository.Identifiable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "kunde")
public class Kunde implements com.example.temaj.observer.Observer, com.example.temaj.observer.Display, Identifiable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKunde;
    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;

//    @OneToOne(mappedBy = "kunde")
//    private Konto konto;
//    private Werbeveranstaltung werbeveranstaltung;

//    public Kunde(Werbeveranstaltung werbeveranstaltung) {
//        this.werbeveranstaltung = werbeveranstaltung;
//        this.werbeveranstaltung.registerObserver(this);
//    }

    public Kunde(String name, String vorname, String email, Date geburtsDatum, Long idKunde, Werbeveranstaltung werbeveranstaltung) {
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.geburtsDatum = geburtsDatum;
        this.idKunde = idKunde;
//        this.werbeveranstaltung = werbeveranstaltung;
    }

    public Kunde() {

    }

    @Override
    public void update(LocalDateTime dateWerbe, String titelWerbe) {
        this.display(dateWerbe, titelWerbe);
    }

    @Override
    public void display(LocalDateTime dateWerbe, String titelWerbe) {
        System.out.println("There is a new Event: " + titelWerbe);
        System.out.println("The date is: " + dateWerbe);
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

    public Long getIdKunde() {
        return idKunde;
    }

    public void setIdKunde(Long idKunde) {
        this.idKunde = idKunde;
    }

    @Override
    public Long getId() {
        return null;
    }
}
