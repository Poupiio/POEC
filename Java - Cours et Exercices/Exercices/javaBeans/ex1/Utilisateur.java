/**
 * Exercice JavaBean 1
 * 
 * Creer un JavaBean Utilisateur ayant les proprietes suivantes :
 * id, nom, mdp, courriel, acces
 */

package cours_exercices.exercices.javaBeans.ex1;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 3202327411722083883L;
	private int id;
	private String nom;
	private String mdp;
	private String courriel;
	private String acces;
	
	Utilisateur() {
		System.out.println("Exécution du constructeur du JavaBean Utilisateur");
	}

	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getMdp() {
		return mdp;
	}
	public String getCourriel() {
		return courriel;
	}
	public String getAcces() {
		return acces;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public void setAcces(String acces) {
		this.acces = acces;
	}
	
}
