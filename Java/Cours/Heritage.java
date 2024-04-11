/**
 * Exemple sur l'heritage
 */

package cours_exercices.cours;

// Classe Compte simple => classe mère
class Compte {
	// Proprietes
	private Double solde;
	private String proprietaire;
	
	// Constructeur
	public Compte(Double solde, String proprietaire) {
        this.solde = solde;
        this.proprietaire = proprietaire;
    }

	// Getters
	public Double getSolde() {
		return this.solde;
	}
	public String getProprietaire() {
		return this.proprietaire;
	}
	
	public String getElements() {
		return "Propriétaire : " + this.proprietaire + " - Solde : " + this.solde;
	}
	
	// J'utilise @Override pour définir une phrase par défaut. Fait la même chose que getElements()
	@Override
	public String toString() {
		return "Propriétaire : " + this.proprietaire + " - Solde : " + this.solde;
	}
	

	// Setters
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	
}


// Classe CompteBancaire heritant de Compte
class CompteBancaire extends Compte {
	// Propriete
	private String nomBanque;

	// Constructeurs
	// Appel le constructeur de la classe mere
	public CompteBancaire() {
		super(100.0, "Elise");			// constructeur classe mère
		this.nomBanque = "À Découvert";		// attribut de l'objet en cours
	}
	
	// Appel le constructeur de la classe mere
	public CompteBancaire(Double solde, String proprietaire, String nomBanque) {
		super(solde, proprietaire);		// constructeur classe mère
		this.nomBanque = nomBanque;		// attribut de l'objet en cours
	}
	
	@Override
	public String getElements() {
		return super.getElements() + " - Nom de la banque : " + this.nomBanque;
	}
	@Override
	public String toString() {
		return super.getElements() + " - Nom de la banque : " + this.nomBanque;
	}
	
	// Getters
	public String getNomBanque() {
		return nomBanque;
	}
	
	// Setters
	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
}


// Classe principale
public class Heritage {
    public static void main(String[] args) {
    	Compte c = new Compte(150.0, "Gourgandine");
    	CompteBancaire cb = new CompteBancaire(1503.89, "Jean-Michel", "LCL");
    	
    	cb.setProprietaire("Jacqueline");
    	cb.setSolde(8751.35);
    	System.out.println(c.getElements());
    	System.out.println(cb.getElements());
    	
    	// Avec la redefinition de la methode toString,
    	// on peut afficher sans appeler explicitement la methode.
    	System.out.println(c);
    	System.out.println(cb);
    }
}