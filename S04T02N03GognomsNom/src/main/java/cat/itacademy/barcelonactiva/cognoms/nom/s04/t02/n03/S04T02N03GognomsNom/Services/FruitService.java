package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Services;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Domain.Fruita;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Repository.FruitRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepo;
    public Fruita crearFruita(Fruita fruita) {

                Fruita fruitaNova = fruitRepo.save(new Fruita(fruita.getId(), fruita.getNom(), fruita.getQuantitatQuilos()));

                return fruitaNova;
            }

    public Optional<Fruita> veureUnaFruita(ObjectId id){

        Optional<Fruita> fruitData = fruitRepo.findById(id);

       return fruitData;
    }

    public List<Fruita> veureTotesFruites(){

        List<Fruita> fruitData = fruitRepo.findAll();

        return fruitData;
    }

    public Fruita modificarFruita(ObjectId id,Fruita fruita){


        Optional<Fruita> fruitData = fruitRepo.findById(id);


        if (fruitData.isPresent()) {

            Fruita novaFruita = fruitData.get();
            novaFruita.setNom(fruita.getNom());
            novaFruita.setQuantitatQuilos(fruita.getQuantitatQuilos());

            Fruita newFruit = fruitRepo.save(new Fruita(novaFruita.getId(), novaFruita.getNom(),novaFruita.getQuantitatQuilos()));

            return newFruit;

        }else{
            System.out.println("No es troba cap fruita amb aquest id");
            return null;
        }
    }

    public Fruita eliminarFruita(ObjectId id){


        Optional<Fruita> fruitData = fruitRepo.findById(id);
        Fruita fruita = fruitData.get();

        if (!fruitData.isEmpty()) {
            fruitRepo.deleteById(id);

        }else{
            System.out.println("No es troba cap fruita amb aquest id");


    }
        return fruita;
}

}
