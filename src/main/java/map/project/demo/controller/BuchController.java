package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.repository.BuchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/buchController")
public class BuchController {

    @Autowired
    private BuchRepo buchRepo;

//    public BuchController(BuchRepo buchRepo) {
//        this.buchRepo = buchRepo;
//    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addBuchRequest(Long idBuch, String title, String autor, String genre, int anzahlSeiten, int erstellungsjahr, float preis) {
        Buch newBuch = new Buch(idBuch, title, autor, genre, anzahlSeiten, erstellungsjahr, preis);
        try {
            if (buchRepo.findBuchByIdBuch(idBuch) != null) {
                buchRepo.save(newBuch);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred ");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteBuchRequest(@PathVariable Long id) {
        try {
            if (buchRepo.findById(id).isPresent()) {
                buchRepo.deleteById(id);
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
    public ResponseEntity<String> updateBuch(
            @PathVariable Long id,
            @RequestBody Buch updatedBuch) {
        try {
            if (buchRepo.getById(id) != null) {
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
        Buch buch = buchRepo.findById(id).get();

        if (buch != null) {
            return ResponseEntity.ok(buch);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Buch>> getAll() {
        List<Buch> Buchs = buchRepo.findAll();
        return ResponseEntity.ok(Buchs);
    }


}