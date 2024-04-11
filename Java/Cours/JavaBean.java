/**
 * Exemple sur JavaBean
 */

package cours_exercices.cours;

import java.io.Serializable;

// Import de Serializable pour creer un JavaBean

// Creation d'un JavaBean
public class JavaBean implements Serializable {

	// Proprietes
	private static final long serialVersionUID = -8655575735257197172L;
	private Integer numero;
	private String libelle;
    
    // Constructeur sans parametres
	public JavaBean() {
		System.out.println("Exécution du constructeur du JavaBean");
	}
    
    // Getters
	public Integer getNumero() {
		return this.numero;
	}
	public String getLibelle() {
		return this.libelle;
	}
    
    // Setters
	public void setNumero(Integer numero){
		this.numero = numero;
	}
	public void setLibelle(String libelle){
		this.libelle = libelle;
	}
}