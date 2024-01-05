package map.project.demo.controller;


import map.project.demo.model.Konto;
import map.project.demo.model.Verlag;
import map.project.demo.model.Werbeveranstaltung;
import map.project.demo.model.requestClasses.VerlagRequest;
import map.project.demo.repository.VerlagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/VerlagController")
public class VerlagController {

    @Autowired
    private VerlagRepo VerlagRepo;

    public VerlagController(VerlagRepo VerlagRepo) {
        this.VerlagRepo = VerlagRepo;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addVerlagRequest(VerlagRequest VerlagRequest) {
        try {
            Verlag newVerlag = new Verlag(
                    VerlagRequest.getIdVerlag(),
                    VerlagRequest.getName(),
                    VerlagRequest.getAdresse(),
                    VerlagRequest.getEmail(),
                    VerlagRequest.getEmail()
            );
            VerlagRepo.save(newVerlag);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Verlag");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteVerlagRequest(@PathVariable Long id) {
        try {
            if (VerlagRepo.getReferenceById(id) != null) {
                VerlagRepo.deleteById(id);
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
    public ResponseEntity<String> updateVerlag(
            @PathVariable Long id,
            @RequestBody Verlag updatedVerlag) {
        try {
            if (VerlagRepo.getReferenceById(id) != null) {
                updatedVerlag.setIdVerlag(id);
                VerlagRepo.save(updatedVerlag);
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
    public ResponseEntity<Verlag> getVerlagById(@PathVariable Long id) {
        Verlag Verlag = VerlagRepo.findById(id).get();

        if (Verlag != null) {
            return ResponseEntity.ok(Verlag);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Verlag>> getAll() {
        List<Verlag> Verlags = VerlagRepo.findAll();
        return ResponseEntity.ok(Verlags);
    }


}
