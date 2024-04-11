/**
 * Exercice Collections
 * 
 * Creer une liste vide
 * Ajouter des elements de type String a cette liste
 * Inserer un element au debut de la liste
 * Afficher le nombre d'element contenu dans la liste
 * Afficher la liste
 * Modifier un element par une autre valeur
 * Parcourir la liste et afficher ses elements un par un
 * Supprimer un element de la liste et reafficher la liste
 */

package cours_exercices.exercices.collection;

import java.util.ArrayList;
import java.util.List;

// Classe principale
public class ExCollection {
    public static void main(String args[]) {
        // Creer un ArrayList
    	List<String> maListe = new ArrayList<>();
        
        // Ajouter des elements a l'ArrayList
    	maListe.add("coucou");
    	maListe.add("toto");
    	
        // Insertion d'un element au debut de la liste
    	maListe.add(0, "élément 1");
        
        // Afficher la taille de la liste
    	System.out.println("Taille de la liste " + maListe.size());
    	
    	System.out.println();
        
        // Afficher l'ArrayList
    	System.out.println("Ma liste : " + maListe);
        
    	System.out.println();
    	
        // Modification d'un element de la liste
    	maListe.set(2, "changement");
        
        // Parcour de la liste
    	for (String elem : maListe) {
    		System.out.println("Elément : " + elem);
    	}
    	
    	System.out.println();
        
        // Supprimer des elements de l'ArrayList
    	maListe.remove("élément 1");
    	maListe.remove(0);
    	
    	System.out.println();
        
        // Afficher l'ArrayList
    	System.out.println("Ma liste après suppression d'éléments : " + maListe);
        
    	System.out.println();
    	
        // Parcour avec la methode ForEach() et une lambda
    	maListe.forEach(elem -> System.out.println("Ma liste : " + elem));
    }
}