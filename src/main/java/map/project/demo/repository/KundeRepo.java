package map.project.demo.repository;



import map.project.demo.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface KundeRepo extends JpaRepository<Kunde, Long> {
//    List<Kunde> kundeList;
//
//    public KundeRepo(List<Kunde> kundeList) {
//
//        this.kundeList = kundeList;
//    }
//
//    public void add(Kunde b){
//        kundeList.add(b);
//    }
//
//    public boolean getById(Long id) {
//        for (Kunde Kunde : kundeList) {
//            if (Kunde.getIdKunde() == id) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void delete(Long id) {
//        for (Kunde Kunde : kundeList) {
//            if (Kunde.getIdKunde() == id) {
//                kundeList.remove(Kunde);
//            }
//        }
//
//    }
//
//    public Kunde update(Long id, Kunde newKunde) {
//        for (int i = 0; i < kundeList.size(); i++) {
//            Kunde Kunde = kundeList.get(i);
//            if (Kunde.getIdKunde().equals(id)) {
//                kundeList.set(i, newKunde);
//                return newKunde;
//            }
//        }
//        return null;
//    }
//
//    public Kunde getByIdentifier(Long id) {
//        for (Kunde b : kundeList) {
//            if (b.getIdKunde().equals(id)) {
//                return b;
//            }
//        }
//        return null;
//    }
//    public List<Kunde> getAll() {
//        return kundeList;
//    }

}
