package map.project.demo.repository;

import map.project.demo.model.Angestellte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface AngestellteRepo extends JpaRepository<Angestellte, Long> {
//    List<Angestellte> angestellteList;
//
//    public AngestellteRepo(List<Angestellte> angestellteList) {
//
//        this.angestellteList = angestellteList;
//    }
//
////    @Override
//    public void add(Angestellte b){
//        angestellteList.add(b);
//    }
//
//    //    @Override
//    public boolean getById(Long id) {
//        for (Angestellte Angestellte : angestellteList) {
//            if (Objects.equals(Angestellte.getIdAngestellte(), id)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Angestellte getByIdentifier(Long id) {
//        return null;
//    }
//
//    public void delete(Long id) {
//        for (Angestellte Angestellte : angestellteList) {
//            if (Objects.equals(Angestellte.getIdAngestellte(), id)) {
//                angestellteList.remove(Angestellte);
//            }
//        }
//
//    }
//
//    public Angestellte update(Long id, Angestellte newAngestellte) {
//        for (int i = 0; i < angestellteList.size(); i++) {
//            Angestellte Angestellte = angestellteList.get(i);
//            if (Angestellte.getIdAngestellte().equals(id)) {
//                angestellteList.set(i, newAngestellte);
//                return newAngestellte;
//            }
//        }
//        return null;
//    }
//
//    public List<Angestellte> getAll() {
//        return angestellteList;
//    }
}
