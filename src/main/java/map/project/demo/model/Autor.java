package map.project.demo.model;

import jakarta.persistence.*;
import map.project.demo.repository.Identifiable;

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

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public Long getId() {
        return null;
    }
}
