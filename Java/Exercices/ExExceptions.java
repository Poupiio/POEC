/**
 * Exercice Exceptions
 * 
 * Ecrire un programme qui demande a l'utilisateur de saisir une liste d'entiers puis a l'aide
 * de parcours successifs de la liste effectuer les actions suivantes :
 * 1) Afficher la liste
 * 2) Afficher la liste en colonne de maniere a afficher l'index et le contenu
 * 3) Creer une nouvelle liste qui sera chaque elements de la liste multiplies par 3
 * 4) Obtenir le plus grand nombre de la liste
 * 5) Obtenir le plus petit nombre de la liste 
 * 6) Compter le nombre des nombres pairs presents dans la liste
 * 7) Calculer la somme de tous les nombres impairs de la liste
 * NB: le programme doit gerer les exceptions au niveau de la saisie des donnees de l'utilisateur
 */

package cours_exercices.exercices.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Classe principale
public class ExExceptions {
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         List<Integer> listeEntiers = new ArrayList<>();

         try {
             // Saisie de la liste d'entiers
             System.out.println("Veuillez saisir une liste d'entiers (séparés par des espaces) :");
             String[] entiersSaisis = scanner.nextLine().split(" ");

             // 1) Afficher la liste
             for (String elem : entiersSaisis) {
                 int entier = Integer.parseInt(elem);
                 listeEntiers.add(entier);
             }
             System.out.println("Liste des entiers : " + listeEntiers);
             System.out.println();
             
             // 2) Afficher la liste en colonne de maniere a afficher l'index et le contenu
             System.out.println("Liste des entiers avec index + contenu : ");
             for (int i = 0; i < listeEntiers.size(); i++) {
                 System.out.println("Index " + i + " : " + listeEntiers.get(i));
             }
             System.out.println();
             
             // 3) Creer une nouvelle liste qui sera chaque elements de la liste multiplies par 3
             List<Integer> nouvelleListe = new ArrayList<>();
             for (int entier : listeEntiers) {
                 nouvelleListe.add(entier * 3);
             }
             System.out.println("Nouvelle liste avec chaque élément multiplié par 3 : " + nouvelleListe);
             System.out.println();
             
             // 4) Obtenir le plus grand nombre de la liste
             int nbMax = Collections.max(nouvelleListe);
             System.out.println("Nombre le plus grand : " + nbMax);
             System.out.println();
             
             // 5) Obtenir le plus petit nombre de la liste 
             int nbMin = Collections.min(nouvelleListe);
             System.out.println("Nombre le plus petit : " + nbMin);
             System.out.println();
             
         } catch (Exception e) {
        	 System.out.println("Erreur");
         }
        // Utilisation de equals() car nous comparons des objets.
        // Le == compare que des valeurs primitives (int, etc ...)
        // Le == fait une comparaison par reference, le equals par valeur pour les objets.
    }
}
