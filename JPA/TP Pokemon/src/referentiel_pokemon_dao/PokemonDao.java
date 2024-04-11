package referentiel_pokemon_dao;

import java.util.List;

import com.bigcorp.persistence.cours.util.PersistenceFactory;
import com.bigcorp.persistence.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import referentiel_pokemons.Pokemon;

public class PokemonDao {
	public Pokemon findById(int id) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		
		Pokemon pokemon = em.find(Pokemon.class, id);
		
		em.close();
		return pokemon;
	}
	
	public Pokemon save(Pokemon pokemon) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Pokemon savedPokemon = em.merge(pokemon);
		
		transaction.commit();
		em.close();
		return savedPokemon;
	}
	
	public void delete(int id) {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		
		Pokemon savedPokemon = em.find(Pokemon.class, id);
		
		if (savedPokemon == null) {
			return;
		}
		// Je stocke le nom du pokemon avant de le supprimer pour l'afficher dans un message par la suite
		String deletedPokemonName = savedPokemon.getName();
		
		// Sinon on ouvre une transaction pour la suppression
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(savedPokemon);
		transaction.commit();
		
		em.close();
		
		System.out.println(deletedPokemonName + " a été supprimé :'(");
	}
	
	public List<Pokemon> getAllPokemons() {
		EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		TypedQuery<Pokemon> query = em.createQuery("select p from Pokemon p", Pokemon.class);

		List<Pokemon> resultList = query.getResultList();
		System.out.print("Voici tous les pokemons : ");
		for (Pokemon allPokemons : resultList) {
			System.out.print(allPokemons.getName() + ", ");
		}
		
		em.close();
		return resultList;
	}
	
	public void update(int id, int newHealthPoints) {
		 EntityManager em = PersistenceFactory.INSTANCE.getEntityManager();
		    EntityTransaction transaction = em.getTransaction();

		    Pokemon savedPokemon = em.find(Pokemon.class, id);

		    if (savedPokemon != null) {
		        String updatedPokemonName = savedPokemon.getName();

		        transaction.begin();

		        Query query = em.createQuery("UPDATE Pokemon p SET p.actualHealthPoints = :newHealthPoints WHERE p.id = :id");
		        query.setParameter("newHealthPoints", newHealthPoints);
		        query.setParameter("id", id);

		        query.executeUpdate();
		        transaction.commit();

		        System.out.println(updatedPokemonName + " a maintenant " + newHealthPoints + " points de vie !");
		    }
		    
		    em.close();
	}
}
