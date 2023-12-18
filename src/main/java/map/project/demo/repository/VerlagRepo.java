package map.project.demo.repository;

import map.project.demo.model.Verlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VerlagRepo extends JpaRepository<Verlag, Long> {

}
//    private static VerlagRepo instance;
//
//    private List<Verlag> verlagList;
//
//    private VerlagRepo(List<Verlag> verlagList) {
//        this.verlagList = verlagList;
//    }
//
//    // Use a synchronized method to ensure thread safety during initialization
//    public static synchronized VerlagRepo getInstance(List<Verlag> verlagList) {
//        if (instance == null) {
//            instance = new VerlagRepo(verlagList);
//        }
//        return instance;
//    }
//
//    @Override
//    public void add(Verlag b) {
//        verlagList.add(b);
//    }
//
//    @Override
//    public void delete(Long id) {
//        verlagList.removeIf(verlag -> id.equals(verlag.getIdVerlag()));
//    }
//
//    @Override
//    public Verlag update(Long id, Verlag newVerlag) {
//        for (int i = 0; i < verlagList.size(); i++) {
//            Verlag verlag = verlagList.get(i);
//            if (id.equals(verlag.getIdVerlag())) {
//                verlagList.set(i, newVerlag);
//                return newVerlag;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Verlag> getAll() {
//        return verlagList;
//    }
//
//    @Override
//    public boolean getById(Long id) {
//        for (Verlag verlag : verlagList) {
//            if (id.equals(verlag.getIdVerlag())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Verlag getByIdentifier(Long id) {
//        return null;
//    }
//
//}
