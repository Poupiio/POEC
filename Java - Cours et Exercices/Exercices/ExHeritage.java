/**
 * Exercice Heritage
 * 
 * Definissez une classe Cercle. Les objets construits a partir de cette classe
 * seront des cercles de tailles variees. En plus de la methode constructeur
 * (qui utilisera donc un parametre rayon), vous definirez les methodes surface et perimetre
 * qui devront renvoyer la surface et le perimetre du cercle.
 * Definissez ensuite une classe Cylindre derivee de la precedente.
 * Le constructeur de cette nouvelle classe comportera les deux parametres rayon et hauteur.
 * Vous y ajouterez une methode volume qui devra renvoyer le volume du cylindre
 * (rappel : volume d'un cylindre = surface de section x hauteur).
 */

package cours_exercices.exercices.heritage;

import java.text.DecimalFormat;

// Classe Cercle
class Cercle {
	// Propriete
	private double rayon;
	
	// Constructeur
	public Cercle(double rayon) {
		this.rayon = rayon;
	}

	// Getters
	public double getRayon() {
		return rayon;
	}

	// Setters
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	// Methodes
	public double surface() {
		System.out.println(Math.PI * Math.pow(this.rayon, 2));
        return Math.PI * Math.pow(rayon, 2);
	}
	public double perimetre() {
        return 2 * Math.PI * this.rayon;
    }
}


// Classe Cylindre
class Cylindre extends Cercle {
	// Propriete
	private int hauteur;

	// Constructeur
	public Cylindre(Double rayon, int hauteur) {
		super(rayon);
		this.hauteur = hauteur;
	}
	
	// Getters
	public int getHauteur() {
		return hauteur;
	}
	
	// Setters
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	// Methode
	// volume d'un cylindre = surface x hauteur
	public double volume(double rayon) {
        return super.surface() * this.hauteur;
	}
}


// Classe principale
public class ExHeritage {
    public static void main(String[] args) {
    	
    	Cercle cercle = new Cercle(10.0);
    	Cylindre cylindre = new Cylindre(25.0, 45);
    	
    	// Pour que les nombres s'arrêtent à 3 chiffres après la virgule
    	DecimalFormat df = new DecimalFormat("#.###");
    	
    	System.out.println("Le cercle de rayon " + cercle.getRayon() + " a pour périmètre " + cercle.perimetre() + " et pour surface " + cercle.surface());
    	System.out.println("Le cylindre de rayon " + cylindre.getRayon() + " et de hauteur " + cylindre.getHauteur() + " a un volume de " + cylindre.volume(0));
    	
    }
}