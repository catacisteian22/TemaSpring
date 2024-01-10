package map.project.demo.repository;

import map.project.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepo extends JpaRepository<Autor, Long> {


}