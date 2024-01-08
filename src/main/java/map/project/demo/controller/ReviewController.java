package map.project.demo.controller;


import map.project.demo.model.Buch;
import map.project.demo.model.Konto;
import map.project.demo.model.Review;
import map.project.demo.model.Werbeveranstaltung;
import map.project.demo.model.requestClasses.ReviewRequest;
import map.project.demo.model.requestClasses.ReviewRequest;
import map.project.demo.repository.BuchRepo;
import map.project.demo.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/ReviewController")
public class ReviewController {

    @Autowired
    private ReviewRepo ReviewRepo;

    @Autowired
    private BuchRepo BuchRepo;

    public ReviewController(ReviewRepo ReviewRepo) {
        this.ReviewRepo = ReviewRepo;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addReviewRequest(ReviewRequest ReviewRequest) {
        try {
            Review newReview = new Review(
                    ReviewRequest.getIdReview(),
                    ReviewRequest.getText(),
                    ReviewRequest.getAnzahlSternchen()
            );
            ReviewRepo.save(newReview);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Review");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteReviewRequest(@PathVariable Long id) {
        try {
            if (ReviewRepo.getReferenceById(id) != null) {
                ReviewRepo.deleteById(id);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateReview(
            @PathVariable Long id,
            @RequestBody Review updatedReview) {
        try {
            if (ReviewRepo.getReferenceById(id) != null) {
                updatedReview.setIdReview(id);
                ReviewRepo.save(updatedReview);
                return ResponseEntity.ok("operation succeeded");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred ");
        }
    }


    @GetMapping(path = "/getByID/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review Review = ReviewRepo.findById(id).get();

        if (Review != null) {
            return ResponseEntity.ok(Review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Review>> getAll() {
        List<Review> Reviews = ReviewRepo.findAll();
        return ResponseEntity.ok(Reviews);
    }
  //many subject,review  teacher ,buch,one
    @PutMapping("/{idReview}/buch/{idBuch}")
    Review assignReviewToBuch(
        @PathVariable Long idBuch,
        @PathVariable Long idReview
    ) {
        Review review = ReviewRepo.findById(idReview).get();
        Buch buch = BuchRepo.findById(idBuch).get();
        review.assignBuch(buch);
        return ReviewRepo.save(review);
    }

}
