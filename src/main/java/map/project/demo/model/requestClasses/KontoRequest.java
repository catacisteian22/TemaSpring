package map.project.demo.model.requestClasses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KontoRequest {
    private Long idKonto;
    private String username;
    private String password;
    private LocalDateTime joinDatum;
    private String typ;
}
