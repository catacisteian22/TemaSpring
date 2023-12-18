package map.project.demo.model;

import com.example.temaj.repository.Identifiable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "konto")
public class Konto implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKonto;
    private String username;
    private String password;
    private LocalDateTime joinDatum;
    private String typ;// kunde oder Angestellte

//    @OneToOne
//    @JoinColumn(name = "idKunde")
//    private Kunde kunde;
//
//    @OneToOne
//    @JoinColumn(name = "idAngestellte")
//    private Angestellte angestellte;

    public Konto(Long idKonto, String username, String password, LocalDateTime joinDatum, String typ) {
        this.username = username;
        this.password = password;
        this.joinDatum = joinDatum;
        this.typ = typ;
        this.idKonto = idKonto;
    }

    public Konto() {

    }

    public Long getIdKonto() {
        return idKonto;
    }

    public void setIdKonto(Long idKonto) {
        this.idKonto = idKonto;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public LocalDateTime getJoinDatum() {
        return joinDatum;
    }

    public void setJoinDatum(LocalDateTime joinDatum) {
        this.joinDatum = joinDatum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Long getId() {
        return null;
    }
}
