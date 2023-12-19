package map.project.demo.observer;

import java.time.LocalDateTime;

public interface Observer {
    public void update(LocalDateTime dateWerbe, String titelWerbe);
}
