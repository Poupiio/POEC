/**
 * Exemple sur les collections
 */

package cours_exercices.cours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Classe principale
public class Collections {
    public static void main(String[] args) {
	/// LIST
	// Creation d'une liste de type List
    	List<String> maListe = new ArrayList<>();
        
        // Ajout d'un element au premier index disponible
    	maListe.add("valeur 1");
    	maListe.add("valeur 3");
        
        // Insert un element a l'index voulu
    	maListe.add(1, "valeur 2");
    	maListe.add(0, "valeur 3");
        
        // Creation d'une autre liste de type List charge avec le contenu de la premiere
    	List<String> monAutreListe = new ArrayList<>();
    	monAutreListe.addAll(maListe);
        
        // Parcour avec une boucle for intelligente
    	for (String elem : maListe) {
    		System.out.println("Elément : " + elem);
    	}
    	
    	System.out.println();
        
        // Parcour avec la methode ForEach() et une lambda
    	maListe.forEach(elem -> System.out.println("Elément : " + elem));
    	
    	System.out.println();
        
        // Acces a un element de la liste via son index
    	System.out.println("Le deuxième élément de ma liste est " + maListe.get(1));
    	
    	System.out.println();
        
		// Recupere le premier index de la liste ayant pour valeur "valeur 1"
    	int indice = maListe.indexOf("valeur 3");
    	System.out.println("Le premier indice pour valeur 3 est " + indice);
    	
    	System.out.println();
	        
		// Recupere le dernier index de la liste ayant pour valeur "valeur 1"       
    	int dernier = maListe.lastIndexOf("valeur 3");
    	System.out.println("Le dernier indice pour valeur 3 est " + dernier);
    	
    	System.out.println();
        
        // Recherche de l'existence d'un element dans une liste
    	System.out.println("La valeur 'valeur 2' existe-t-elle ? " + maListe.contains("valeur 2"));
    	System.out.println("La valeur 'valeur 4' existe-t-elle ? " + maListe.contains("valeur 4"));
    	
    	System.out.println();
        
		// Taille de la liste
    	System.out.println("Taille de la liste : " + maListe.size());
    	
    	System.out.println();
	        
		// Suppression de l'element a l'index 1
    	maListe.remove(1);
    	System.out.println("Taille de la liste : " + maListe.size());
    	
    	System.out.println();
	        
		// Suppression de l'element ayant la valeur "valeur 2"
    	maListe.remove("valeur 2");
    	System.out.println("Taille de la liste : " + maListe.size());
    	
    	System.out.println();
	        
		// Suppression de tous les elements de la liste
    	maListe.clear();
    	System.out.println("Taille de la liste : " + maListe.size());
    	
    	System.out.println();
	        
		/// SET
		// Definition d'une collection Set
    	Set<String> monSet = new HashSet<>();
        
        // Charge monAutreListe de type List dans monSet de type Set
    	monSet.addAll(monAutreListe);
        
        // Affichage du Set, on s'apercoit qu'il n'y a plus de doublons
    	System.out.println("Eléments du Set : " + monSet);
    	
    	System.out.println();
        
		// Tableau de String charge
    	String[] valeurs = {"un", "deux", "trois"};
	    
		// Conversion du tableau en liste de type List
    	//List<String> maNouvelleListe = (List<String>) Arrays.asList(valeurs);
    	List<String> maNouvelleListe = List.of(valeurs);

		// Affichage de la nouvelle liste
    	System.out.println("Ma nouvelle liste : " + maNouvelleListe);
    	
    	System.out.println();
        
    	// Creation d'une liste de type List
    	// List<Integer> listeInteger = Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1 ,3, 8, 6);
    	// sans passer par l'import de la classe Arrays
    	List<Integer> listeInteger = List.of(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1 ,3, 8, 6);
    	System.out.println("Liste Integer : " + listeInteger);
    	
    	System.out.println();
	        
		// Conversion en Set d'une liste d'int de type List, il n'y a plus de doublons
    	Set<Integer> setInteger = new HashSet<>(listeInteger);
    	System.out.println("Eléments du setInteger : " + setInteger);
    	
    	System.out.println();
    	
		// Ajout de la valeur 5, mais elle existe deja
    	setInteger.add(5);
    	System.out.println("Eléments du setInteger après l'ajout de la valeur 5 : " + setInteger);
    	
    	System.out.println();
	        
		// Creation d'une liste de type List 
    	// List<String> listeString = Arrays.asList("toto", "abc", "xyz", "dede", "abc");
    	// sans passer par l'import de la classe Arrays
    	List<String> listeString = List.of("toto", "abc", "xyz", "dede", "abc");
    	System.out.println("Liste String : " + listeString);
    	
    	System.out.println();
    	
		// Conversion en Set d'une liste de String de type List, il n'y a plus de doublons
    	Set<String> setString = new HashSet<>(listeString);
    	System.out.println("Eléments du setString : " + setString);
    	
    	System.out.println();
        
        // MAP
    	HashMap<Integer, String> jours = new HashMap<>();
    	jours.put(1, "lundi");
    	jours.put(2, "mardi");
    	jours.put(3, "mercredi");
    	jours.put(4, "jeudi");
    	jours.put(5, "vendredi");
    	jours.put(6, "samedi");
    	jours.put(7, "dimanche");
    	
    	System.out.println(jours.get(1));
    	System.out.println();
    	jours.replace(5,  "friday");
    	System.out.println(jours.get(5));
    }
}