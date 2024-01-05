package map.project.demo.model.requestClasses;
import jakarta.persistence.OneToOne;
import lombok.Data;
import map.project.demo.model.Konto;

import java.util.Date;

@Data
public class KundeRequest {

    private Long idKunde;

    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;

    //@OneToOne(mappedBy = "kunde")
    //private Konto konto;
}
