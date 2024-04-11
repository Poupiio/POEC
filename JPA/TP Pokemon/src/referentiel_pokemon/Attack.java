package referentiel_pokemon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attack")
public class Attack {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)

    private int id;
    private String name;
    private String species;
    private String type;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return this.species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
}