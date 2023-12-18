package map.project.demo.model;

import com.example.temaj.observer.Observable;
import com.example.temaj.observer.Observer;
import com.example.temaj.repository.Identifiable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
@Entity
@Table(name = "werbeveranstaltung")
public class Werbeveranstaltung implements Identifiable {// implements Observable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idWerbe;
    private LocalDateTime dateWerbe;
    private String titelWerbe;
//    private ArrayList<Observer> observerKunden;

    public Werbeveranstaltung() {
//        observerKunden = new ArrayList<>();
    }

    public void createEvent(Long idWerbe, LocalDateTime dateWerbe, String titelWerbe) {
        this.setIdWerbe(idWerbe);
        this.setDateWerbe(dateWerbe);
        this.setTitelWerbe(titelWerbe);
//        this.notifyObservers();
    }

//    @Override
//    public void registerObserver(Observer observer) {
//        observerKunden.add(observer);
//    }

//    @Override
//    public boolean removeObserver(Observer observer) {
//        return observerKunden.remove(observer);
//    }

//    @Override
//    public void notifyObservers() {
//        for (Observer observer : observerKunden) {
//            observer.update(this.dateWerbe, this.titelWerbe);
//        }
//    }

    public String getTitelWerbe() {
        return titelWerbe;
    }

    public void setTitelWerbe(String titelWerbe) {
        this.titelWerbe = titelWerbe;
    }

    public LocalDateTime getDateWerbe() {
        return dateWerbe;
    }

    public void setDateWerbe(LocalDateTime dateWerbe) {
        this.dateWerbe = dateWerbe;
    }

    public Long getIdWerbe() {
        return idWerbe;
    }

    public void setIdWerbe(Long idWerbe) {
        this.idWerbe = idWerbe;
    }

    @Override
    public Long getId() {
        return null;
    }
}
