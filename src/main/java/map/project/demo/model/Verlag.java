package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

@Data
@Entity
@Table(name = "verlag")
public class Verlag implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVerlag;

    private String name;
    private String adresse;
    private String telefonNummer;
    private String email;

    public Verlag(Long idVerlag, String name, String adresse, String telefonNummer, String email) {
        this.idVerlag = idVerlag;
        this.name = name;
        this.adresse = adresse;
        this.telefonNummer = telefonNummer;
        this.email = email;
    }

    @Override
    public Long getId() {
        return idVerlag;
    }

}
