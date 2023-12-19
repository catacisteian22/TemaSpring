package map.project.demo.controller;

import map.project.demo.model.Konto;
import map.project.demo.repository.KontoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/kontoController")
public class KontoController {

    @Autowired
    private KontoRepo kontorepo;

    public KontoController(KontoRepo kontorepo) {
        this.kontorepo = kontorepo;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addKontoRequest(Long idKonto,String username, String password, LocalDateTime joinDatum, String typ) {
        Konto newKonto = new Konto(idKonto,username, password, joinDatum, typ);
        try {
            if (kontorepo.getReferenceById(idKonto) != null) {
                kontorepo.save(newKonto);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Konto");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteKontoRequest(@PathVariable Long id) {
        try {
            if (kontorepo.getReferenceById(id) != null) {
                kontorepo.deleteById(id);
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
    public ResponseEntity<String> updateKonto(
            @PathVariable Long id,
            @RequestBody Konto updatedKonto) {
        try {
            if (kontorepo.getReferenceById(id) != null) {
                updatedKonto.setIdKonto(id);
                kontorepo.save(updatedKonto);
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
    public ResponseEntity<Konto> getKontoById(@PathVariable Long id) {
        Konto konto = kontorepo.findById(id).get();

        if (konto != null) {
            return ResponseEntity.ok(konto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Konto>> getAll() {
        List<Konto> Kontos = kontorepo.findAll();
        return ResponseEntity.ok(Kontos);
    }
}
