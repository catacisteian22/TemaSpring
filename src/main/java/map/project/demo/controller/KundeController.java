package map.project.demo.controller;

import map.project.demo.model.Kunde;
import map.project.demo.model.requestClasses.KundeRequest;
import map.project.demo.repository.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> addKundeRequest(KundeRequest kundeRequest) {
        try {
            Kunde newKunde = new Kunde(
                    kundeRequest.getIdKunde(),
                    kundeRequest.getName(),
                    kundeRequest.getVorname(),
                    kundeRequest.getEmail(),
                    kundeRequest.getGeburtsDatum()
            );
            kundeRepo.save(newKunde);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Kunde");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteKundeRequest(@PathVariable Long id) {
        try {
            if (kundeRepo.getReferenceById(id) != null) {
                kundeRepo.deleteById(id);
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
            if (kundeRepo.getReferenceById(id) != null) {
                updatedKunde.setIdKunde(id);
                kundeRepo.save(updatedKunde);
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
        Kunde kunde = kundeRepo.findById(id).get();

        if (kunde != null) {
            return ResponseEntity.ok(kunde);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Kunde>> getAll() {
        List<Kunde> Kundes = kundeRepo.findAll();
        return ResponseEntity.ok(Kundes);
    }


}
