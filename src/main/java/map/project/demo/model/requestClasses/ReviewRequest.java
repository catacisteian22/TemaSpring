package map.project.demo.model.requestClasses;
import lombok.Data;

@Data
public class ReviewRequest {
    private Long idReview;
    private String text;
    private Integer anzahlSternchen;

}
