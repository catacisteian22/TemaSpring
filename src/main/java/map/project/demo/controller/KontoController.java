package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.model.Konto;
import map.project.demo.model.requestClasses.KontoRequest;
import map.project.demo.repository.KontoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/kontoController")
public class KontoController {

    @Autowired
    private KontoRepo kontorepo;

    public KontoController(KontoRepo kontorepo) {
        this.kontorepo = kontorepo;
    }

    @PostMapping(path = "/addKunde/{idKunde}")
    public ResponseEntity<String> addKontoKunde(KontoRequest kontoRequest, @PathVariable Buch idKunde) {
        try {
            Konto newKonto = new Konto(
                    kontoRequest.getIdKonto(),
                    kontoRequest.getUsername(),
                    kontoRequest.getPassword(),
                    kontoRequest.getJoinDatum(),
                    kontoRequest.getTyp()
//                    kontoRequest.getIdKunde
            );
            kontorepo.save(newKonto);
            return ResponseEntity.ok("operation succeeded!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }


//    @PostMapping(path = "/addAngestellte/{idAngestellte)")
//    public ResponseEntity<String> addKontoAngestellte(KontoRequest


//    @DeleteMapping(path = "/delete/{id}")
//    public ResponseEntity<String> deleteKontoRequest(@PathVariable Long id) {
//        try {
//            if (kontorepo.getReferenceById(id) != null) {
//                kontorepo.deleteById(id);
//                return ResponseEntity.ok("operation succeeded!");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
//        }
//    }

//    @PutMapping(path = "/update/{id}")
//    public ResponseEntity<String> updateKonto(
//            @PathVariable Long id,
//            @RequestBody Konto updatedKonto) {
//        try {
//            if (kontorepo.getReferenceById(id) != null) {
//                updatedKonto.setIdKonto(id);
//                kontorepo.save(updatedKonto);
//                return ResponseEntity.ok("operation succeeded");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred ");
//        }
//    }


//    @GetMapping(path = "/getByID/{id}")
//    public ResponseEntity<Konto> getKontoById(@PathVariable Long id) {
//        Konto konto = kontorepo.findById(id).get();
//
//        if (konto != null) {
//            return ResponseEntity.ok(konto);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    @PostMapping(path = "/getAll")
//    public ResponseEntity<List<Konto>> getAll() {
//        List<Konto> Kontos = kontorepo.findAll();
//        return ResponseEntity.ok(Kontos);
//    }
}
