/**
 * Exemple sur les variables
 */

package cours_exercices.cours;

import java.util.Scanner;

// Classe principale
public class Variables {
    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
        // Operateur d'affectation Simple
    	int i = 1;
        
        // Affichage simple d'une variable
    	System.out.println("Affichage simple d'une variable : " + i);
    	
        // Affectation multiple
        String a, b, c = b = a = "Test";
        int x, y, z = y = x = 5;
        System.out.println("Affichage multiple string : " + a + " " + b + " " + c);
        System.out.println("Affichage multiple int : " + x + " " + y + " " + z);
        
        // Boxing (Conversion automatique du type primitif en son équivalent objet)
        Integer i2 = i;
        System.out.println("Boxing : " + i2);
        
        // Unboxing (Conversion automatique de l’objet en son type primitif)
        int val = i2;
        System.out.println("Unboxing : " + val);
        
        // Casting (forcer la conversion temporaire d’une variable)
        int k = 5;
        System.out.println("Casting : " + (float)k);
        System.out.println(k);
        
        // Conversion d'une String en classe Integer
        String chaine = "100";
        Integer valInt = Integer.valueOf(chaine);
        System.out.println(valInt);
        
        // Conversion d'une String en int primitif
        int j = Integer.parseInt(chaine);
        System.out.println("Conversion d'une String en int primitif " + j);
        
        // Conversion d'un double en String
        double d = 3.1415926;
        String pi = Double.toString(d);
        System.out.println("Conversion d'un double en String " + d);
        System.out.println(pi);
        
        // Operateur arithmetique simple
        i = i + 1;
        System.out.println("i + 1 = " + i);
        
        // Operateur unitaire postfixe
        System.out.println("Postfixe : " + i++);
        
        // Operateur unitaire prefixe
        System.out.println("Prefixe : " + ++i);
        
        // Operateur binaire
        System.out.println(i == j);
        
        // Comparaison avec des chaines de caracteres 
        System.out.println(chaine.equals(pi));
        
        // Operateur de comparaison logique
        i = i2;
        System.out.println(i == i2 || chaine.equals(pi));
        
        // Operateur de negation
        System.out.println(!chaine.equals(pi));
        
        // Operateur avec assignation
        i += 10;
        System.out.println(i);
        
        // Saisir au clavier et affecter la saisie à une variable
        var keyb = new Scanner(System.in);
        
        // Recuperer la ligne saisie
        System.out.println("Entrez votre nom : ");
        String nom = keyb.nextLine();
        
        // Recuperer un caractere
        System.out.println("Entrez votre genre : ");
        char genre = keyb.next().charAt(0);
        
        // Recuperer un entier
        System.out.println("Entrez votre age : ");
        int age = keyb.nextInt();
        
        // Recuperer un nombre à virgule (ne pas saisir un point)
        System.out.println("Entrez taille : ");
        double taille = keyb.nextDouble();
        
        // Recuperer un boolean (saisir true ou false seulement)
        System.out.println("Etes-vous celibataire : ");
        boolean marier = keyb.nextBoolean();
        
        // Affichage des variables
        System.out.println("Nom : " + nom + "\nAge : " + age + "\nGenre : " + genre + "\nTaille : " + taille + "\nEtat marital : " + !marier + "\n");
        keyb.close();
    }
}