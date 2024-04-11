/**
 * Exercice JavaBean 2
 * 
 * Creer un javaBeans Article ayant les proprietes suivantes :
 * numero, libelle
 */

package cours_exercices.exercices.javaBeans.ex2;

import java.io.Serializable;

// Import de Serializable pour creer un JavaBean
public class Article implements Serializable {

	private static final long serialVersionUID = 1428673470407916939L;
	private Integer numero;
	private String libelle;
	
	public Article() {
		System.out.println("Exécution du constructeur du JavaBean Article");
	}
	
	public Integer getNumero() {
		return numero;
	}
	public String getLibelle() {
		return libelle;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}