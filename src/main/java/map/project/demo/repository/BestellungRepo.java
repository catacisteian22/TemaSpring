package map.project.demo.repository;

import map.project.demo.model.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestellungRepo extends JpaRepository<Bestellung, Long> {


}