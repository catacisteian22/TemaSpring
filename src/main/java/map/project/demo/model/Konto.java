package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.time.LocalDateTime;

@Data
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

    @OneToOne
    @JoinColumn(name = "id_kunde")
    private Kunde kunde;

    @OneToOne
    @JoinColumn(name = "id_angestellte")
    private Angestellte angestellte;

    public Konto(Long idKonto, String username, String password, LocalDateTime joinDatum, String typ) {
        this.username = username;
        this.password = password;
        this.joinDatum = joinDatum;
        this.typ = typ;
        this.idKonto = idKonto;
    }

    public Konto() {

    }
    @Override
    public Long getId() {
        return idKonto;
    }
}