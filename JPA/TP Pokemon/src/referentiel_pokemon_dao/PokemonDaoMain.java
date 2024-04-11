package referentiel_pokemon_dao;

import referentiel_pokemons.Pokemon;
import referentiel_pokemons.PokemonTypeAndAttack;

public class PokemonDaoMain {
	public static void main(String[] args) {
		PokemonDao pokemonDao = new PokemonDao();
		
		Pokemon carapuce = new Pokemon();
		carapuce.setName("Carapuce");
		carapuce.setAttack("Plouf");
		carapuce.setType(PokemonTypeAndAttack.EAU);
		carapuce.setActualHealthPoints(100);
		
		Pokemon salameche = new Pokemon();
		salameche.setName("Salamèche");
		salameche.setAttack("Flamèche");
		salameche.setType(PokemonTypeAndAttack.FEU);
		salameche.setActualHealthPoints(100);
		
		Pokemon roucoul = new Pokemon();
		roucoul.setName("Roucoul");
		roucoul.setAttack("Air");
		roucoul.setType(PokemonTypeAndAttack.AIR);
		roucoul.setActualHealthPoints(90);
		
		Pokemon racaillou = new Pokemon();
		racaillou.setName("Racaillou");
		racaillou.setAttack("Sol");
		racaillou.setType(PokemonTypeAndAttack.SOL);
		racaillou.setActualHealthPoints(110);
		
		pokemonDao.save(carapuce);
		pokemonDao.save(salameche);
		pokemonDao.save(roucoul);
		pokemonDao.save(racaillou);
		
		Pokemon pokemon = pokemonDao.findById(1);

		if (pokemon == null) {
			System.out.println("Aucun pokemon trouvé en base.");
		} else {
			System.out.println("Un pokemon a été trouvé ! Il s'agit de " + pokemon.getName());
		}
		
		// pokemonDao.delete(3);
		
		// Affichage de tous les pokemons présents en base
		pokemonDao.getAllPokemons();
		
		// Modification d'un pokemon (modif des points de vie)
		pokemonDao.update(1, 6700);
	}
}
