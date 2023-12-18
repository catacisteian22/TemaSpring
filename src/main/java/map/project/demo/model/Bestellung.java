package map.project.demo.model;

import jakarta.persistence.*;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bestellung")
public class Bestellung implements Identifiable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idBestellung;
    private LocalDateTime datum;
    private float gesamtpreis;
    private String adresse;
//    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL)
//    private List<Buch> listeBucher;

    public Bestellung(Long idBestellung, LocalDateTime datum, float gesamtpreis, String adresse) {
        this.idBestellung = idBestellung;
        this.datum = datum;
        this.gesamtpreis = gesamtpreis;
        this.adresse = adresse;
//        this.listeBucher = listeBucher;
    }

    public Bestellung(ResultSet resultSet) {
        super();
    }

    public Bestellung() {

    }

//    @Override
//    public ArrayList<Buch> getListeBucher() {
//        return (ArrayList<Buch>) listeBucher;
//    }

//    @Autowired
//    private DiscountStrategy discountStrategy;

//    public Bestellung(DiscountStrategy discountStrategy) {
//        this.discountStrategy = discountStrategy;
//    }
//
//    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
//        this.discountStrategy = discountStrategy;
//    }

//    public float calculateGesamtpreis(float gesamtpreis) {
//        return discountStrategy.applyDiscount(gesamtpreis);
//    }

//    public void setListeBucher(List<Buch> listeBucher) {
//        this.listeBucher = listeBucher;
//    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getGesamtpreis() {
        return gesamtpreis;
    }

    public void setGesamtpreis(float gesamtpreis) {
        this.gesamtpreis = gesamtpreis;
    }

    public Long getIdBestellung() {
        return idBestellung;
    }

    public void setIdBestellung(Long idBestellung) {
        this.idBestellung = idBestellung;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    @Override
    public Long getId() {
        return null;
    }
}
