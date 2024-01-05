package map.project.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import map.project.demo.repository.Identifiable;

import java.util.List;

@Data
@Entity
@Table(name = "wishlist")
public class Wishlist implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idWishlist;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
    private List<Buch> listeBucher;

    @Override
    public Long getId() {
        return idWishlist;
    }
}
