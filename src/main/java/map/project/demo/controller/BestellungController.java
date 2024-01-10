package map.project.demo.controller;

import map.project.demo.model.*;
import map.project.demo.model.requestClasses.BestellungRequest;
import map.project.demo.repository.BestellungRepo;
import map.project.demo.repository.BuchRepo;
import map.project.demo.service.BestellungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/bestellungController")
public class BestellungController {

    @Autowired
    private BestellungRepo bestellungRepo;

    @Autowired
    private BuchRepo buchRepo;

    @Autowired
    private BestellungService service;

    // Create a new wishlist
    @PostMapping("/create")
    public ResponseEntity<String> createBestellung(@RequestBody BestellungRequest bestellungRequest) {
        float gesamtPreis = calculateTotalPrice(bestellungRequest.getListeBucherInBestellung());
        try {
            Bestellung newBestellung = new Bestellung(
                    bestellungRequest.getIdBestellung(),
                    bestellungRequest.getDatum(),
                    gesamtPreis,
                    bestellungRequest.getAdresse()
            );
            bestellungRepo.save(newBestellung);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @PutMapping("/{bestellungId}/bestellungen/{buchId}")
    Bestellung addBuchToBestellung(
            @PathVariable Long bestellungId,
            @PathVariable Long buchId
    ) {
        service.addBuchToBestellung(bestellungId, buchId);

        return bestellungRepo.findById(bestellungId).orElse(null);
    }


@GetMapping("/getAll/{bestellungId}") // Get all books from a bestellung
public ResponseEntity<List<Buch>> getAllBooksFromBestellung(@PathVariable Long bestellungId) {
    Optional<Bestellung> bestellungOptional = bestellungRepo.findById(bestellungId);

    if (bestellungOptional.isPresent()) {
        Bestellung bestellung = bestellungOptional.get();
        List<Buch> booksInBestellung = bestellung.getListeBucherInBestellung();

        return ResponseEntity.ok(booksInBestellung);
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

public float calculateTotalPrice(List<Long> chosenBooksIDs) {

    float totalPrice = 0;

    for (Long id_book : chosenBooksIDs) {
        if (!buchRepo.getReferenceById(id_book).equals(null)) {
            totalPrice += buchRepo.getReferenceById(id_book).getPreis();
        }

    }
    return totalPrice;
}


}