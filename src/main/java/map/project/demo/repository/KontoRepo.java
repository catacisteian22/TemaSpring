package map.project.demo.repository;

import map.project.demo.model.Konto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontoRepo extends JpaRepository<Konto, Long> {

}
