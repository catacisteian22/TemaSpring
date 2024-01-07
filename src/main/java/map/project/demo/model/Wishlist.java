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

    @ManyToMany
    @JoinTable(
            name="bucher_in_wishlist",
            joinColumns = @JoinColumn(name = "wishlist_ID"),
            inverseJoinColumns = @JoinColumn(name = "buchId")
    )
    private List<Buch> listeBucherInWishlist;

    @Override
    public Long getId() {
        return idWishlist;
    }
}










