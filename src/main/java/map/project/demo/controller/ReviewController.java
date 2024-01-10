package map.project.demo.controller;

import map.project.demo.model.Review;
import map.project.demo.model.requestClasses.ReviewRequest;
import map.project.demo.repository.BuchRepo;
import map.project.demo.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/reviewController")
public class ReviewController {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private BuchRepo buchRepo;

    public ReviewController(ReviewRepo ReviewRepo) {
        this.reviewRepo = ReviewRepo;
    }

    @PostMapping(path = "/add/{id_buch}")
    public ResponseEntity<String> addReviewRequest(ReviewRequest ReviewRequest, @PathVariable Long buchID) {

        try {
            if (buchRepo.getReferenceById(buchID) != null) {

                Review newReview = new Review(
                        ReviewRequest.getIdReview(),
                        ReviewRequest.getText(),
                        ReviewRequest.getAnzahlSternchen()
                );
                reviewRepo.save(newReview);
            }
            return ResponseEntity.ok("operation succeeded!");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteReviewRequest(@PathVariable java.lang.Long id) {
        try {
            if (reviewRepo.getReferenceById(id) != null) {
                reviewRepo.deleteById(id);
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
            @PathVariable java.lang.Long id,
            @RequestBody Review updatedReview) {
        try {
            if (reviewRepo.getReferenceById(id) != null) {
                updatedReview.setIdReview(id);
                reviewRepo.save(updatedReview);
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
    public ResponseEntity<Review> getReviewById(@PathVariable java.lang.Long id) {
        Review Review = reviewRepo.findById(id).get();

        if (Review != null) {
            return ResponseEntity.ok(Review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Review>> getAll() {
        List<Review> Reviews = reviewRepo.findAll();
        return ResponseEntity.ok(Reviews);
    }

    //many subject,review  teacher ,buch,one
//    @PutMapping("/{idReview}/buch/{idBuch}")
//    Review assignReviewToBuch(
//            @PathVariable java.lang.Long idBuch,
//            @PathVariable java.lang.Long idReview
//    ) {
//        Review review = ReviewRepo.findById(idReview).get();
//        Buch buch = BuchRepo.findById(idBuch).get();
//        review.assignBuch(buch);
//        return ReviewRepo.save(review);
//    }

}
