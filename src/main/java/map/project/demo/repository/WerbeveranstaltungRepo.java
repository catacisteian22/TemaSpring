package map.project.demo.repository;

import map.project.demo.model.Werbeveranstaltung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerbeveranstaltungRepo extends JpaRepository<Werbeveranstaltung, Long> {
}