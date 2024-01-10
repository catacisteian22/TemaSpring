package map.project.demo.repository;

import map.project.demo.model.Verlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerlagRepo extends JpaRepository<Verlag, Long> {

}