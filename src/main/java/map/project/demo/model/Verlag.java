package map.project.demo.model;

import com.example.temaj.repository.Identifiable;
import jakarta.persistence.*;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdVerlag() {
        return idVerlag;
    }

    public void setIdVerlag(Long idVerlag) {
        this.idVerlag = idVerlag;
    }

    @Override
    public Long getId() {
        return idVerlag;
    }
}
