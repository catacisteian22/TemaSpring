package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.model.requestClasses.BuchRequest;
import map.project.demo.repository.BuchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/buchController")
public class BuchController {

    @Autowired
    private BuchRepo buchRepo;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addBuchRequest(@RequestBody BuchRequest buchRequest) {
        try {
            Buch newBuch = new Buch(
                    buchRequest.getIdBuch(),
                    buchRequest.getTitle(),
                    buchRequest.getAutor(),
                    buchRequest.getGenre(),
                    buchRequest.getAnzahlSeiten() != null ? buchRequest.getAnzahlSeiten() : 0,
                    buchRequest.getErstellungsjahr() != null ? buchRequest.getErstellungsjahr() : 0,
                    buchRequest.getPreis() != null ? buchRequest.getPreis() : 0
            );
            buchRepo.save(newBuch);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteBuchRequest(@PathVariable Long id) {
        try {

            if (buchRepo.findById(id) != null) {
                buchRepo.deleteById(id);
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
    public ResponseEntity<String> updateBuch(
            @PathVariable Long id,
            @RequestBody Buch updatedBuch) {
        try {
            if (buchRepo.getReferenceById(id) != null) {
                updatedBuch.setIdBuch(id);
                buchRepo.save(updatedBuch);
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
    public ResponseEntity<Buch> getBuchById(@PathVariable Long id) {
        try {
            Optional<Buch> optionalBuch = buchRepo.findById(id);

            if (optionalBuch.isPresent()) {
                Buch buch = optionalBuch.get();
                return ResponseEntity.ok(buch);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Buch>> getAll() {
        try {
            List<Buch> bucher = buchRepo.findAll();
            if (!bucher.isEmpty()) {
                return ResponseEntity.ok(bucher);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}