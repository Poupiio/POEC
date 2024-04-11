package referentiel_pokemon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon_species")
public class PokemonSpecies {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)

    private int id;
    private String name;
    private String baseAttack;
    private int initialHealthPoints;

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

    public String getBaseAttack() {
        return this.baseAttack;
    }
    public void setBaseAttack(String baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getActualHealthPoints() {
        return this.initialHealthPoints;
    }
    public void setInitialHealthPoints(int initialHealthPoints) {
        this.initialHealthPoints = initialHealthPoints;
    }

}
