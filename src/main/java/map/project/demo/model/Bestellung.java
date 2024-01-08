package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "bestellung")
public class Bestellung implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBestellung;
    private LocalDateTime datum;
    private float gesamtpreis;
    private String adresse;

    @ManyToMany
    @JoinTable(
            name="bucher_in_bestellung",
            joinColumns = @JoinColumn(name = "bestellung_ID"),
            inverseJoinColumns = @JoinColumn(name = "buch_ID")
    )
    private List<Buch> listeBucherInBestellung;

    public Bestellung(Long idBestellung, LocalDateTime datum, float gesamtpreis, String adresse, List<Buch> listeBucher) {
        this.idBestellung = idBestellung;
        this.datum = datum;
        this.gesamtpreis = gesamtpreis;
        this.adresse = adresse;
        this.listeBucherInBestellung = listeBucher;
    }
    public Bestellung(){
    }

    @Override
    public Long getId() {
        return idBestellung;
    }

//    public static class BestellungBuilder {
//        private LocalDateTime datum;
//        private String adresse;
//        private List<Buch> listeBucherB;
//
//        public BestellungBuilder withDatum(LocalDateTime datum) {
//            this.datum = datum;
//            return this;
//        }
//
//        public BestellungBuilder withAdresse(String adresse) {
//            this.adresse = adresse;
//            return this;
//        }
//
//        public BestellungBuilder withListeBucher(List<Buch> listeBucher) {
//            this.listeBucherB = listeBucher;
//            return this;
//        }
//
//        public static Bestellung build() {
//            if (adresse == null || listeBucherB == null || listeBucherB.isEmpty()) {
//                throw new IllegalStateException("Adresse and Liste Bucher are mandatory.");
//            }
//
//            Bestellung bestellung = new Bestellung();
//            bestellung.datum = this.datum;
//            bestellung.adresse = this.adresse;
//            bestellung.listeBucher = this.listeBucherB;
//            bestellung.gesamtpreis = calculateGesamtpreis(listeBucherB);
//
//            return bestellung;
//        }

        private float calculateGesamtpreis(List<Buch> bucher) {
            float total = 0.0f;
            for (Buch buch : bucher) {
                total += buch.getPreis();
            }
            return total;
        }
    }
//}
