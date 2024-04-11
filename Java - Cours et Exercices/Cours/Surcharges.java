/**
 * Exemple sur les surcharges
 */

package cours_exercices.cours;

// Classe Imprimante avec surcharge de la methode imprimer()
class Imprimante {
	
	public void imprimer() {
		System.out.println("Impression d'une page de test.");
	}
	
	public void imprimer(String doc1, String doc2) {
		System.out.println("imprimer() 1");
		System.out.println(doc1 + " " + doc2);
	}
	
	public void imprimer(String document, Integer nombre) {
		System.out.println("imprimer() 2");
		
		for (int indice = 0; indice < nombre; indice++) {
			System.out.println("J'imprime le document " + document + " " + nombre + " fois.");
		}
	}
	
	public void imprimer(String... doc1) {
		System.out.println("imprimer() 3");
		
		for (String doc : doc1) {
			System.out.println("Document imprimé : " + doc);
		}
	}
}

// Classe principale
public class Surcharges {
    public static void main(String[] args) {
    	Imprimante imprimante = new Imprimante();
    	
    	imprimante.imprimer();
    	
    	// fonctionne avec String[} et String...
    	imprimante.imprimer(new String[] {"doc1", "doc2", "doc3", "doc4"});
    	
    	// ne fonctionne qu'avec String...
    	imprimante.imprimer("Document 1");
    	
    	imprimante.imprimer("Document 2", "Document 3");
    	imprimante.imprimer("Document 4", "Document 5");
    	
    	imprimante.imprimer("Document 4", 3);
    }
}