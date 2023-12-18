package map.project.demo.repository;

import map.project.demo.model.Werbeveranstaltung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerbeveranstaltungRepo extends JpaRepository<Werbeveranstaltung, Long> {

//    List<Werbeveranstaltung> wbsList;
//
//    public WerbeveranstaltungRepo(List<Werbeveranstaltung> wbsList) {
//
//        this.wbsList = wbsList;
//    }
//
////    @Override
//    public void add(Werbeveranstaltung b){
//        wbsList.add(b);
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public Werbeveranstaltung update(Long id, Werbeveranstaltung newEntity) {
//        return null;
//    }
//
//    //    @Override
//    public Werbeveranstaltung getById(LocalDateTime date) {
//        for (Werbeveranstaltung Werbeveranstaltung : wbsList) {
//            if (Werbeveranstaltung.getDateWerbe() == date) {
//                return Werbeveranstaltung;
//            }
//        }
//        return null;
//    }
//
//    public void delete(LocalDateTime date) {
//        for (Werbeveranstaltung Werbeveranstaltung : wbsList) {
//            if (Werbeveranstaltung.getDateWerbe() == date) {
//                wbsList.remove(Werbeveranstaltung);
//            }
//        }
//
//    }
//
//    public Werbeveranstaltung update(LocalDateTime date, Werbeveranstaltung newWerbeveranstaltung) {
//        for (int i = 0; i < wbsList.size(); i++) {
//            Werbeveranstaltung Werbeveranstaltung = wbsList.get(i);
//            if (Werbeveranstaltung.getDateWerbe().equals(date)) {
//                wbsList.set(i, newWerbeveranstaltung);
//                return newWerbeveranstaltung;
//            }
//        }
//        return null;
//    }
//
//    public List<Werbeveranstaltung> getAll() {
//        return wbsList;
//    }
//
//    @Override
//    public boolean getById(Long id) {
//        return false;
//    }
//
//    @Override
//    public Werbeveranstaltung getByIdentifier(Long id) {
//        return null;
//    }

}
