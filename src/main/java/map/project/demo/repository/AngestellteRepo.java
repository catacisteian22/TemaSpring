package map.project.demo.repository;

import map.project.demo.model.Angestellte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AngestellteRepo extends JpaRepository<Angestellte, Long> {
}