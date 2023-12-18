package map.project.demo.repository;

import map.project.demo.model.Buch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuchRepo extends JpaRepository<Buch, Long> {


    Buch findBuchByIdBuch(long id);



//    public List<Buch> findBuchByAnzahlSeitenEmptyAndAndGenre(int anzahl, String Genre);

//    private BuchRepo(List<Buch> buchList) {
//        this.buchList = buchList;
//    }

//    public static BuchRepo getInstance(List<Buch> buchList) {
//        if (instance == null) {
//            instance = new BuchRepo(buchList);
//        }
//        return instance;
//    }
//
//    public BuchRepo() {
//    }
//
//    public List<Buch> getBuchList() {
//        return buchList;
//    }
//
//    public void setBuchList(List<Buch> buchList) {
//        this.buchList = buchList;
//    }


}
