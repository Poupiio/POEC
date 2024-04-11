/**
 * Exemple sur les getters et les setters
 */

package cours_exercices.cours;

// Classe Velo
class Velo {
	// Attribut
	private int nbRoues = 2;
	
	// Getter : permet d'accéder à la valeur initiale de l'attribut
	public int getNbRoues() {
		return this.nbRoues;
	}
	
	// Setter : permet de modifier la valeur de l'attribut
	public void setNbRoues(int nbRoues){
		this.nbRoues = nbRoues;
	}
	
}

// Classe principale
public class GettersSetters {
    public static void main(String[] args) {
    	Velo v = new Velo();
    	
    	System.out.println(v.getNbRoues());
    	
    	v.setNbRoues(3);
    	System.out.println(v.getNbRoues());
    }
}