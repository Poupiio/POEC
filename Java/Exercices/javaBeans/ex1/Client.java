/**
 * Exercices JavaBean
 * 
 * Creer un JavaBean Client ayant les proprietes suivantes :
 * id, nom, prenom, societe, courriel, telFixe, telMobile, notes, actif
 */

package cours_exercices.exercices.javaBeans.ex1;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

// JavaBean Client
public class Client implements Serializable {

	// Proprietes
	private static final long serialVersionUID = -5263838871049027688L;	
	private int id;
	private String nom;
	private String prenom;
	private String societe;
	private String courriel;
	private int telFixe;
	private int telMobile;
	private int notes;
	private boolean actif;


	// Constructeurs
	Client() {
		System.out.println("Exécution du constructeur du JavaBean Client");
	}
	
	// Getters
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getSociete() {
		return societe;
	}
	public String getCourriel() {
		return courriel;
	}
	public int getTelFixe() {
		return telFixe;
	}
	public int getTelMobile() {
		return telMobile;
	}
	public int getNotes() {
		return notes;
	}
	public boolean getActif() {
		return actif;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public void setTelFixe(int telFixe) {
		this.telFixe = telFixe;
	}
	public void setTelMobile(int telMobile) {
		this.telMobile = telMobile;
	}
	public void setNotes(int notes) {
		this.notes = notes;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}

}
