package map.project.demo.model.requestClasses;

import lombok.Data;
import map.project.demo.model.Buch;

import java.util.List;

@Data
public class WishlistRequest {
    private java.lang.Long idWishlist;
    private List<Buch> listeBucherInWishlist;
}
