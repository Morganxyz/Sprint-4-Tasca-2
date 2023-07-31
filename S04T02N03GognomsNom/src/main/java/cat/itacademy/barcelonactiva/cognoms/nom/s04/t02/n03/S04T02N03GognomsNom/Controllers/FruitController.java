package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Controllers;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Domain.Fruita;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Services.FruitService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8083")
@RequestMapping("/fruita")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> add(@RequestBody Fruita fruita) {

        try {
            return new ResponseEntity<>(fruitService.crearFruita(fruita), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")

    public ResponseEntity<Fruita> getOne(@PathVariable(name = "id") ObjectId id) {

        Optional<Fruita> fruita = fruitService.veureUnaFruita(id);

        if (fruita.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(fruita.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")

    public ResponseEntity<Fruita> getAll() {

        try {
            List<Fruita> fruits = new ArrayList<>();
            fruits.addAll(fruitService.veureTotesFruites());

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(fruits, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")

    public ResponseEntity<Fruita> delete(@PathVariable(name = "id") ObjectId id) {

        try {
            Fruita fruitaEliminada = fruitService.eliminarFruita(id);

            if (fruitaEliminada != null) {
                return new ResponseEntity<>(fruitaEliminada, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Fruita> update(@PathVariable(name = "id") ObjectId id, @RequestBody Fruita fruita) {

        try {
            Optional<Fruita> fruitData = fruitService.veureUnaFruita(id);

            if (fruitData.isPresent()) {
                return new ResponseEntity<>(fruitService.modificarFruita(id,fruita), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
