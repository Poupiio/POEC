/**
 * Exemple sur l'iteration de collection
 */

package cours_exercices.cours;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Classe principale
public class IterationsCollections {
    public static void main(String[] args) {
        // LIST
        // Creation d'une liste de type List
    	List<String> maListe = new ArrayList<>();
    	maListe.add("valeur 1");
    	maListe.add(1, "valeur 2");
    	maListe.add(0, "valeur 3");
    	maListe.add("valeur 1");
    	
          
        // Utilisation de l'interface Iterator
    	System.out.println("Parcours de la liste avec itérateur");
        
        // Recuperation d'un "Iterator" sur la liste voulue
    	Iterator<String> monIterateur = maListe.iterator();
    	
        // Parcours de la liste. La methode hasNext() verifie s'il y a encore un element dans la liste
    	while (monIterateur.hasNext()) {
    		// La méthode next() passe à l'élément suivant de la liste
    		String element = monIterateur.next();
    		System.out.println(element);
    	}
    	System.out.println();
    	
        // Parcours de la liste avec une boucle for classique 
    	System.out.println("Parcours de la liste avec boucle for classique :");
    	for (int monIndice = 0; monIndice < maListe.size(); monIndice++) {
    		String monElement = maListe.get(monIndice);
    		System.out.println(monElement);
    	}
    	System.out.println();
    	
        // Parcours de la liste avec une boucle for "intelligente"
    	System.out.println("Parcours de la liste avec boucle for intelligente :");
    	for (String elem : maListe) {
    		System.out.println(elem);
    	}
    	System.out.println();
    	
        // Parcours de la liste avec une methode forEach() 
    	// La fonction donnee dans forEach est une fonction lambda.
    	System.out.println("Parcours de la liste avec la méthode forEach :");
    	maListe.forEach(e -> System.out.println(e));
    	System.out.println();
    	
    	// Parcours de la liste avec une référence de méthode
    	System.out.println("Parcours de la liste avec une référence de méthode");
    	maListe.forEach(System.out::println);
    	
    }
}