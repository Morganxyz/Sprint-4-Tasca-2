package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.Services;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.Domain.Fruita;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.Repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepo;
    public Fruita crearFruita(Fruita f0) {

                Fruita fruitaNova = fruitRepo.save(new Fruita(f0.getId(), f0.getNom(), f0.getQuantitatQuilos()));

                return fruitaNova;
            }


    public Optional<Fruita> veureUnaFruita(int id){

        Optional<Fruita> fruitData = fruitRepo.findById(id);

       return fruitData;
    }

    public List<Fruita> veureTotesFruites(){

        List<Fruita> fruitData = fruitRepo.findAll();

        return fruitData;
    }

    public Fruita modificarFruita(int id,Fruita fruita){


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

    public Fruita eliminarFruita(int id){


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
