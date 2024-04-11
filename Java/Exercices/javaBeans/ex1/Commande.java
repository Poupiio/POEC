/**
 * Exercice JavaBean 1
 * 
 * Creer un JavaBean Commande ayant les proprietes suivantes :
 * id, clientId, libelle, prixUnitaire, nombreDeJours, tva, etats, type, notes
 */

package cours_exercices.exercices.javaBeans.ex1;

// Import de Serializable pour creer un JavaBean
import java.io.Serializable;

//JavaBean Client
public class Commande implements Serializable {

	// Proprietes
	private static final long serialVersionUID = 4089467644727327137L;
	private int id;
	private int clientId;
	private String libelle;
	private float prixUnitaire;
	private int nombreDeJours;
	private float tva;
	private String etats;
	private String types;
	private String notes;


	// Constructeurs
	Commande() {
		System.out.println("Exécution du constructeur du JavaBean Commande");
	}


	public int getId() {
		return id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setId(int id) {
		this.id = id;
	}




	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public int getNombreDeJours() {
		return nombreDeJours;
	}


	public void setNombreDeJours(int nombreDeJours) {
		this.nombreDeJours = nombreDeJours;
	}


	public float getTva() {
		return tva;
	}


	public void setTva(float tva) {
		this.tva = tva;
	}


	public String getEtats() {
		return etats;
	}


	public void setEtats(String etats) {
		this.etats = etats;
	}


	public String getTypes() {
		return types;
	}


	public void setTypes(String types) {
		this.types = types;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

}