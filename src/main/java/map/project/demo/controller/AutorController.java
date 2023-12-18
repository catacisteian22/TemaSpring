package map.project.demo.controller;

import map.project.demo.model.Autor;
import map.project.demo.repository.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/autorController")
public class AutorController {

    @Autowired
    private AutorRepo autorRepo;

    public AutorController() {

    }

    //autorController/add
    @PostMapping(path = "/add")
    public ResponseEntity<String> addAutorRequest(Long idAutor, String name, String vorname) {
        Autor newAutor = new Autor(idAutor, name, vorname);
        try {
            if (autorRepo.getReferenceById(idAutor) != null) {
                autorRepo.save(newAutor);
                return ResponseEntity.ok("operation succeeded!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" id not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting Autor");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteAutorRequest(@PathVariable Long id) {
        try {
            if (autorRepo.getReferenceById(id) != null) {
                autorRepo.deleteById(id);
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
    public ResponseEntity<String> updateAutor(
            @PathVariable Long id,
            @RequestBody Autor updatedAutor) {
//        Autor updatedAutor = new Autor(id,)
        try {
            if (autorRepo.getReferenceById(id) != null) {
                autorRepo.save(id, updatedAutor);
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
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Autor autor = autorRepo.getReferenceById(id);

        if (autor != null) {
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping(path = "/getAll")
    public ResponseEntity<List<Autor>> getAll() {
        List<Autor> autors = autorRepo.findAll();
        return ResponseEntity.ok(autors);
    }

}