package map.project.demo.model.requestClasses;
import lombok.Data;

@Data
public class VerlagRequest {
    private Long idVerlag;
    private String name;
    private String adresse;
    private String telefonNummer;
    private String email;
}
