package map.project.demo.model.requestClasses;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BestellungRequest {

    private Long idBestellung;
    private LocalDateTime datum;
    private String adresse;
    private List<Long> listeBucherInBestellung;
}
