package map.project.demo.model.requestClasses;

import lombok.Data;
import map.project.demo.model.Buch;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BestellungRequest {

    private Long idBestellung;
    private LocalDateTime datum;
//    private float gesamtpreis;
    private String adresse;
    private List<Buch> listeBucherInBestellung;
}
