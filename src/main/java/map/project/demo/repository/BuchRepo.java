package map.project.demo.repository;

import map.project.demo.model.Buch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchRepo extends JpaRepository<Buch, Long> {

//    Buch findBuchByIdBuch(long id);

}
