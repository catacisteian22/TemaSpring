package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL)
    private List<Buch> listeBucher;

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

    @Override
    public Long getId() {
        return null;
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

}
