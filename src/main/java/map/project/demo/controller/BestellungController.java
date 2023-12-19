package map.project.demo.controller;

import map.project.demo.model.*;
import map.project.demo.repository.BestellungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path="/bestellungController")
public class BestellungController {

    @Autowired
    private BestellungRepo bestellungRepo;


    public BestellungController() {
    }

    //    public BestellungController(BestellungRepo bestellungRepo, KontoRepo kontoRepo, BuchRepo buchRepo) {
//        this.buchRepo = buchRepo;
//        this.kontoRepo = kontoRepo;
//        this.bestellungRepo = bestellungRepo;
//    }


    @PostMapping(path = "/add")
    public ResponseEntity<String> addBestellungRequest(Long idBestellung, LocalDateTime datum, float gesamtpreis, String adresse, List<Buch> listeBucher) {
        Bestellung newBestellung = new Bestellung(idBestellung, datum,  gesamtpreis,  adresse);
        try {
            if (bestellungRepo.getReferenceById(idBestellung) != null) {
                bestellungRepo.save(newBestellung);
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
    public ResponseEntity<String> deleteBestellungRequest(@PathVariable Long id) {
        try {
            if (bestellungRepo.getReferenceById(id) != null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            } else {
                bestellungRepo.deleteById(id);
                return ResponseEntity.ok("operation succeeded!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateBestellung(
            @PathVariable Long id,
            @RequestBody Bestellung updatedBestellung) {
        try {
            if (bestellungRepo.getReferenceById(id) != null) {
                updatedBestellung.setIdBestellung(id);
                bestellungRepo.save(updatedBestellung);
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
    public ResponseEntity<Bestellung> getBestellungById(@PathVariable Long id) {
        Bestellung bestellung = bestellungRepo.getReferenceById(id);

        if (bestellung != null) {
            return ResponseEntity.ok(bestellung);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Bestellung>> getAll() {
        List<Bestellung> Bestellungs = bestellungRepo.findAll();
        return ResponseEntity.ok(Bestellungs);
    }
    public float calculateTotalPrice(List<Buch> chosenBooks) {
        float totalPrice = 0;

        for (Buch book : chosenBooks) {
            totalPrice += book.getPreis();
        }

        return totalPrice;
    }

}
