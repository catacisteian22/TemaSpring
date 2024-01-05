package map.project.demo.model.requestClasses;

import jakarta.persistence.OneToOne;
import lombok.Data;
import map.project.demo.model.Konto;

import java.util.Date;

@Data
public class AngestellteRequest {
    private Long idAngestellte;

    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;
    private String rolle;
    private int gehalt;

    //@OneToOne(mappedBy = "angestellte")
    //private Konto konto;
}
