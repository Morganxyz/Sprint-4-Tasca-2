package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.Repository;
import java.util.List;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.Domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruita, Integer>{
}
