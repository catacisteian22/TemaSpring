package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.repository.BuchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/buchController")
public class BuchController {

    @Autowired
    private BuchRepo buchRepo;

//    public BuchController(BuchRepo buchRepo) {
//        this.buchRepo = buchRepo;
//    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addBuchRequest(
            Long idBuch,
            @RequestBody Map<String, Object> requestBody) {
        String title = (String) requestBody.get("title");
        String autor = (String) requestBody.get("autor");
        String genre = (String) requestBody.get("genre");
        Integer anzahlSeiten = (Integer) requestBody.get("anzahl_seiten");
        Integer erstellungsjahr = (Integer) requestBody.get("erstellungsjahr");
        Float preis = requestBody.get("preis") != null ? ((Number) requestBody.get("preis")).floatValue() : 0;

        Buch newBuch = new Buch(idBuch, title, autor, genre,
                anzahlSeiten != null ? anzahlSeiten : 0,
                erstellungsjahr != null ? erstellungsjahr : 0,
                preis);
        try {
            if (buchRepo.findBuchByIdBuch(idBuch) != null) {
                buchRepo.save(newBuch);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
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