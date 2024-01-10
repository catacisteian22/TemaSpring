package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "werbeveranstaltung")
public class Werbeveranstaltung implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idWerbe;
    private LocalDateTime dateWerbe;
    private String titelWerbe;

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

    @Override
    public Long getId() {
        return idWerbe;
    }
}
