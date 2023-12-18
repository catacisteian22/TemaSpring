package map.project.demo.controller;


import map.project.demo.model.Kunde;
import map.project.demo.repository.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/kundeController")
public class KundeController {

    @Autowired
    private KundeRepo kundeRepo;

    public KundeController(KundeRepo kundeRepo) {
        this.kundeRepo = kundeRepo;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addKundeRequest(String name, String vorname, String email, Date geburtsDatum, Long idKunde, Werbeveranstaltung werbeveranstaltung) {
        Kunde newKunde = new Kunde(name, vorname, email, geburtsDatum, idKunde,  werbeveranstaltung);
        try {
            if (!kundeRepo.getById(idKunde)) {
                kundeRepo.add(newKunde);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Kunde");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteKundeRequest(@PathVariable Long id) {
        try {
            if (kundeRepo.getById(id)) {
                kundeRepo.delete(id);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateKunde(
            @PathVariable Long id,
            @RequestBody Kunde updatedKunde) {
        try {
            if (kundeRepo.getById(id)) {
                kundeRepo.update(id, updatedKunde);
                return ResponseEntity.ok("operation succeeded");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred ");
        }
    }


    @GetMapping(path = "/getByID/{id}")
    public ResponseEntity<Kunde> getKundeById(@PathVariable Long id) {
        Kunde Kunde = kundeRepo.getByIdentifier(id);

        if (Kunde != null) {
            return ResponseEntity.ok(Kunde);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Kunde>> getAll() {
        List<Kunde> Kundes = kundeRepo.getAll();
        return ResponseEntity.ok(Kundes);
    }


}