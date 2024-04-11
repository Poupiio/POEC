/**
 * Exercices methodes
 * 
 * 1. Definir une methode maximum(n1, n2, n3) qui renvoie le plus grand 
 * des 3 nombres n1, n2, n3 fourni en arguments.
 * exemple : maximum(2, 15, 5) doit afficher : 15
 * 
 * 2. Ecrire une fonction cube qui retourne le cube de son argument.
 * Ecrire une fonction volumeSphere qui calcule le volume d'une sphere de rayon r
 * fourni en argument et qui utilise la fonction cube. 
 */

package cours_exercices.exercices.methodes;

import java.math.BigInteger;

import cours_exercices.cours.Methodes;

// Classe principale
public class ExMethodes {
    // Methode maximum
	public int maximum(int n1, int n2, int n3) {
		int max1 = Math.max(n1, n2);
        int result = Math.max(max1, n3);
        return result;
	}
	
    // Methode cube
	public double cube(double nombre) {
		double result = Math.pow(nombre, 3);
		return result;
	}
	
    // Methode volume
	public double volumeSphere(double rayon) {
        double volume = (4.0 / 3.0) * Math.PI * cube(rayon);
        return volume;
	}
    
    // Methode principale
	public static void main(String[] args) {
		ExMethodes meth = new ExMethodes();
		System.out.println("Le nombre maximum est " + meth.maximum(10, 196, 15856));
		
		System.out.println("Le nombre au cube est " + meth.cube(5));
		
		System.out.println("Le volume d'une sphère de rayon 6 est " + meth.volumeSphere(6.0));
	}
}