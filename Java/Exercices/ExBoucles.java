/**
 * Exercice Boucles
 * 
 * 1. Afficher tous les nombres entiers de 1 a 20 en utilisant la boucle for et while.
 * 2. Afficher les 20 premiers resultats d'une table de multiplication
 * sous la forme : 1 x 5 = 5 etc...
 * 3. Afficher les tables de multiplication pour les nombres de 5 a 10 inclus.
 */

package cours_exercices.exercices.boucles;

// Classe principale
public class ExBoucles {
    public static void main(String[] args) {
        // Affichage avec la boucle for
    	System.out.println("Boucle for :");
    	for (int i = 1; i <= 20; i++) {
    		System.out.println(i);
    	}
    	System.out.println();
         
        // Affichage avec la boucle while
    	System.out.println("Boucle while :");
    	int j = 1;
    	while (j <= 20) {
    		System.out.println(j);
    		j++;
    	}
    	System.out.println();
        
        // Table de multiplication
    	System.out.println("Table de multiplication de 5 (de 1 à 20) :");
    	int multiplicateur = 5;
    	for (int i = 1; i <= 20; i++) {
            int resultat = i * multiplicateur;
            System.out.println(i + " x " + multiplicateur + " = " + resultat);
        }
        System.out.println();
        
        // Table de multiplication des nombres 5 a 10 inclus
        System.out.println("Table de multiplication de 5 à 10 (de 1 à 20) :");
        for (int k = 5; k <= 10; k++) {
            for (int l = 1; l <= 20; l++) {
                int resultat = k * l;
                System.out.println(k + " x " + l + " = " + resultat);
            }
        }
        
    }
}