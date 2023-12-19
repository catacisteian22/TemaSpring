package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

@Data
@Entity
@Table(name = "autor")
public class Autor implements Identifiable {

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAutor;
    private String name;
    private String vorname;


    public Autor(Long idAutor, String name, String vorname) {
    }

    public Autor() {

    }

    @Override
    public Long getId() {
        return null;
    }
}
