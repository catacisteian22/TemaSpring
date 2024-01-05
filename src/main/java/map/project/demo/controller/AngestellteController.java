package map.project.demo.controller;

import map.project.demo.model.Angestellte;
import map.project.demo.model.requestClasses.AngestellteRequest;
import map.project.demo.repository.AngestellteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/angestellteController")
public class AngestellteController {

    @Autowired
    private AngestellteRepo AngestellteRepo;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addAngestellteRequest(@RequestBody AngestellteRequest AngestellteRequest) {
        try {
            Angestellte newAngestellte = new Angestellte(
                    AngestellteRequest.getIdAngestellte(),
                    AngestellteRequest.getName(),
                    AngestellteRequest.getVorname(),
                    AngestellteRequest.getEmail(),
                    AngestellteRequest.getGeburtsDatum() ,
                    AngestellteRequest.getRolle(),
                    AngestellteRequest.getGehalt()
            );
            AngestellteRepo.save(newAngestellte);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteAngestellteRequest(@PathVariable Long id) {
        try {

            if (AngestellteRepo.findById(id) != null) {
                AngestellteRepo.deleteById(id);
                return ResponseEntity.ok("Operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateAngestellte(
            @PathVariable Long id,
            @RequestBody Angestellte updatedAngestellte) {
        try {
            if (AngestellteRepo.getReferenceById(id) != null) {
                updatedAngestellte.setIdAngestellte(id);
                AngestellteRepo.save(updatedAngestellte);
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
    public ResponseEntity<Angestellte> getAngestellteById(@PathVariable Long id) {
        try {
            Optional<Angestellte> optionalAngestellte = AngestellteRepo.findById(id);

            if (optionalAngestellte.isPresent()) {
                Angestellte Angestellte = optionalAngestellte.get();
                return ResponseEntity.ok(Angestellte);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Angestellte>> getAll() {
        try {
            List<Angestellte> Angestellteer = AngestellteRepo.findAll();
            if (!Angestellteer.isEmpty()) {
                return ResponseEntity.ok(Angestellteer);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}