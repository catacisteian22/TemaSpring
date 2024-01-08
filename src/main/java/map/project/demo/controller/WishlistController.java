package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.model.Wishlist;
import map.project.demo.model.requestClasses.WishlistRequest;
import map.project.demo.repository.BuchRepo;
import map.project.demo.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/wishlistController")
public class WishlistController {

    @Autowired
    private WishlistRepo wishlistRepo;

    @Autowired
    private BuchRepo buchRepo;

    // Create a new wishlist
    @PostMapping("/create")
    public ResponseEntity<String> createWishlist(@RequestBody WishlistRequest wishlistRequest) {
        try {
            Wishlist newWishlist = new Wishlist(
                    wishlistRequest.getIdWishlist(),
                    wishlistRequest.getListeBucherInWishlist()
                    );
            wishlistRepo.save(newWishlist);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @PutMapping("/{wishlistId}/wishlists/{buchId}")
    Wishlist addBuchToWishlist(
            @PathVariable Long wishlistId,
            @PathVariable Long buchId
    ) {
        Wishlist wishlist = wishlistRepo.findById(wishlistId).get();
        Buch buch = buchRepo.findById(buchId).get();
        wishlist.getListeBucherInWishlist().add(buch);

        return wishlistRepo.save(wishlist);
    }

    @GetMapping("/getAll/{wishlistId}") // Get all books from a wishlist
    public ResponseEntity<List<Buch>> getAllBooksFromWishlist(@PathVariable Long wishlistId) {
        Optional<Wishlist> wishlistOptional = wishlistRepo.findById(wishlistId);

        if (wishlistOptional.isPresent()) {
            Wishlist wishlist = wishlistOptional.get();
            List<Buch> booksInWishlist = wishlist.getListeBucherInWishlist();

            return ResponseEntity.ok(booksInWishlist);
        } else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update a wishlist by ID
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Wishlist> updateWishlist(@PathVariable Long id, @RequestBody Wishlist wishlistDetails) {
//        Optional<Wishlist> wishlist = wishlistRepo.findById(id);
//        if (wishlist.isPresent()) {
//            Wishlist updatedWishlist = wishlist.get();
//            updatedWishlist.setListeBucherInWishlist(wishlistDetails.getListeBucherInWishlist());
//
//            wishlistRepo.save(updatedWishlist);
//            return ResponseEntity.ok(updatedWishlist);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Delete a wishlist by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWishlist(@PathVariable Long id) {
        Optional<Wishlist> wishlist = wishlistRepo.findById(id);
        if (wishlist.isPresent()) {
            wishlistRepo.deleteById(id);
            return ResponseEntity.ok("Wishlist deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

