package map.project.demo.controller;

import map.project.demo.model.*;
import map.project.demo.repository.BestellungRepo;
import map.project.demo.repository.BuchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/bestellungController")
public class BestellungController {

    @Autowired
    private BestellungRepo bestellungRepo;

    @Autowired
    private BuchRepo buchRepo;

    public BestellungController() {
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addBestellungRequest(
            @RequestParam Long idBestellung,
            @RequestParam LocalDateTime datumBestellung,
            @RequestParam String adresse,
            @RequestBody List<Long> listeBucherIds) { // Assuming these are IDs of the Buch entities

        try {
            // Create a list to store Buch entities based on the provided IDs
            List<Buch> bucher = new ArrayList<>();
            for (Long buchId : listeBucherIds) {
                // Fetch the Buch entity from the repository
                Buch buch = buchRepo.findById(buchId).orElseThrow(() -> new RuntimeException("Buch not found for id: " + buchId));
                bucher.add(buch);
            }

            // Calculate total price
            float gesamtPreis = calculateTotalPrice(bucher);

            // Create a new Bestellung instance
            Bestellung newBestellung = new Bestellung();
            newBestellung.setIdBestellung(idBestellung);
            newBestellung.setDatum(datumBestellung);
            newBestellung.setGesamtpreis(gesamtPreis);
            newBestellung.setAdresse(adresse);
            newBestellung.setListeBucher(bucher);

            // Save the new Bestellung instance
            bestellungRepo.save(newBestellung);

            return ResponseEntity.ok("Operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

//    @PostMapping(path = "/add")
//    public ResponseEntity<String> addBestellungRequest(Long idBestellung, LocalDateTime datumBestellung, String adresse, List<Buch> listeIdBucher) {
//        float gesamtPreis = calculateTotalPrice(listeIdBucher);
//        Bestellung newBestellung = new Bestellung(idBestellung, datumBestellung, gesamtPreis, adresse, listeIdBucher);
//        try {
//            bestellungRepo.save(newBestellung);
//            return ResponseEntity.ok("Operation succeeded!");
//        } catch (
//                Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred ");
//        }
//    }


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

//    @PostMapping(path = "/createBestellungWithKunde")
//    public ResponseEntity<String> createBestellungWithKunde(@RequestBody BestellungRequest bestellungRequest,
//                                                            @RequestBody Kunde kunde) {
//        try {
//
//            if (bestellungRequest == null || kunde == null) {
//                return ResponseEntity.badRequest().body("Invalid input data.");
//            }
//
//            Bestellung newBestellung = Bestellung.BestellungBuilder.build()
//                    .withKunde(kunde)
//                    .withDatum(bestellungRequest.getDatum())
//                    .withListeBucher(bestellungRequest.getListeBucher())
//                    .build();
//
//            bestellungRepo.save(newBestellung);
//
//            return ResponseEntity.ok("Bestellung created successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
//        }
//    }

    public float calculateTotalPrice(List<Buch> chosenBooks) {
        float totalPrice = 0;

        for (Buch book : chosenBooks) {
            totalPrice += book.getPreis();
        }

        return totalPrice;
    }

}
