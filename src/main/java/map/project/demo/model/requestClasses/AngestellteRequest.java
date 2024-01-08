package map.project.demo.model.requestClasses;

import lombok.Data;

import java.util.Date;

@Data
public class AngestellteRequest {

    private Long idAngestellte;

    private String name;
    private String vorname;
    private String email;
    private Date geburtsDatum;
    private String rolle;
    private Integer gehalt;

}
