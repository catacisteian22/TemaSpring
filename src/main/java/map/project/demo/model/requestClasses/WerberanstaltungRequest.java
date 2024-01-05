package map.project.demo.model.requestClasses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WerberanstaltungRequest {
    private Long idWerbe;
    private LocalDateTime dateWerbe;
    private String titelWerbe;
}