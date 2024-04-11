package referentiel_pokemon;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	
	private int id;
	private String name;
	private String attack;
	@Enumerated(EnumType.STRING)
	private PokemonTypeAndAttack type;
	private int actualHealthPoints;
	private int xp;
	
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
	
	public String getAttack() {
		return attack;
	}
	public void setAttack(String attack) {
		this.attack = attack;
	}
	
	public PokemonTypeAndAttack getType() {
		return this.type;
	}
	public void setType(PokemonTypeAndAttack type) {
		this.type = type;
	}
	
	public int getActualHealthPoints() {
		return this.actualHealthPoints;
	}
	public void setActualHealthPoints(int actualHealthPoints) {
		this.actualHealthPoints = actualHealthPoints;
	}
	
	public int getXp() {
		return this.xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
}
