package map.project.demo.repository;

import map.project.demo.model.Review;
import map.project.demo.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {

}
