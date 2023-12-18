package map.project.demo.repository;

import map.project.demo.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishlistRepo extends JpaRepository<Wishlist, Long> {

//
//    List<Wishlist> wishList;
//
//    public WishlistRepo(List<Wishlist> wishlist) {
//
//        this.wishList = wishlist;
//    }
//
//    public void add(Wishlist k){
//        wishList.add(k);
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public Wishlist update(Long id, Wishlist new_entity) {
//        return null;
//    }
//
//    public boolean getById(Long id) {
//        for (Wishlist wishlist : wishList) {
//            if (wishlist.getIdWishlist() == id) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Wishlist getByIdentifier(Long id) {
//        return null;
//    }
//
//    public List<Wishlist> getAll() {
//        return wishList;
//    }
}
