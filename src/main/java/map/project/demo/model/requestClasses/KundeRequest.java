package map.project.demo.model.requestClasses;

import lombok.Data;

import java.util.Date;

@Data
public class KundeRequest {

    private Long idKunde;
    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;

}
