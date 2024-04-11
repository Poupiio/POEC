/*
* Exercice Tableaux
* 
* 1. Ecrire dans un tableau les valeurs suivantes : 1, 1, 2, 3, 5, 8, 13, 21
* 2. Creer un autre tableau ayant un element de plus que le premier initialiser a 0.
* 3. Afficher les elements du premier tableau.
* 4. Afficher les elements du 2eme tableau.
* 5. Copier les valeurs du premier tableau dans le second et inserer une valeur aribitraire a la 3eme position.
* 6. Afficher le tableau apres l'operation d'insertion.
*/
 
package cours_exercices.exercices.tableaux;

import java.util.ArrayList;

// Classe principale
public class ExTableaux {
    // Methode principale
    public static void main(String[] args) {
    	int[] tableau = {1, 1, 2, 3, 5, 8, 13, 21};
    	int[] tableau2 = new int[tableau.length + 1];
    	int pos = 2;	// initialisation de la variable pour l'index
    	
        // Afficher les elements du tableau original
    	System.out.println("Eléments du tableau original : ");
    	for (int elements : tableau) {
    		System.out.println(elements);
    	}
        
        // Afficher les elements du nouveau tableau
    	System.out.println("Eléments du tableau 2 : ");
    	for (int elements : tableau2) {
    		System.out.println(elements);
    	}
    	
        // Copie des elements du premier tableau
        // et insertion d'un element a la 3eme position
    	for (int i = 0; i < tableau.length; i++) {
    		if (i < pos) {
    			tableau2[i] = tableau[i];
    		}
    		if (i >= pos) {
    			tableau2[i + 1] = tableau[i];
    		}
    	}
    	
    	tableau2[pos] = 45;
        
        // Afficher le tableau apres l'operation d'insertion
    	System.out.println("Nouveau tableau : ");
    	for (int i = 0; i < tableau2.length; i++) {
    		System.out.print(tableau2[i]);
    		
    		if (i < tableau2.length - 1) {
    			System.out.print(", ");
    		}
    	}
        
        // Message de fin
    	System.out.println("\nFin");
    }
}