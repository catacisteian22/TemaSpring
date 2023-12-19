package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.observer.Display;
import map.project.demo.observer.Observer;
import map.project.demo.repository.Identifiable;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "kunde")
public class Kunde implements Observer, Display, Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKunde;

    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;

    @OneToOne(mappedBy = "kunde")
    private Konto konto;

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

    @Override
    public Long getId() {
        return idKunde;
    }
}
