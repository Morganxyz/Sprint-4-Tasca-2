package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.Domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Fruites")

public class Fruita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nom;
    @Column
    private int quantitatQuilos;

}
