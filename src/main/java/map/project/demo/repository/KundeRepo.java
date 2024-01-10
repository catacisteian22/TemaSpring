package map.project.demo.repository;

import map.project.demo.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KundeRepo extends JpaRepository<Kunde, Long> {

}
