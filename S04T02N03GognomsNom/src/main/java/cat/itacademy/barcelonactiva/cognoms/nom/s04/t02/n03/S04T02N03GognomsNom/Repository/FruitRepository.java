package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Repository;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.Domain.Fruita;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<Fruita, ObjectId> {

}
