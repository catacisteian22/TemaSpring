package map.project.demo.model;

import com.example.temaj.repository.Identifiable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class Wishlist implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idWishlist;

//    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
//    private List<Buch> listeBucher;

    public Long getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(Long idWishlist) {
        this.idWishlist = idWishlist;
    }

    @Override
    public Long getId() {
        return null;
    }

//    public List<Buch> getListeBucher() {
//        return listeBucher;
//    }
//
//    public void setListeBucher(ArrayList<Buch> listeBucher) {
//        this.listeBucher = listeBucher;
//    }
}
