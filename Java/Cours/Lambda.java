/**
 * Exemple sur les expressions lambda
 */

package cours_exercices.cours;

// Interface fonctionnelle
// Inutile de mettre implements lors de son utilisation
// car elle n'a qu'une seule methode
@FunctionalInterface
interface IOperation {
	public int calc(int x, int y);
}

// Classe principale
public class Lambda {
    // Methode statique appelant la methode calc de notre objet fourni en parametres
	public static int calculer(int x, int y, IOperation op) {
		return op.calc(x, y);
	}
    
    // Methode principale
    public static void main(String args[]) {
        // Definition des objets implementant l'interface Operation via une lambda
        // Avec la declaration de type
    	IOperation addition = (int x, int y) -> x + y;
        
        // Sans declaration de type, ni return, ni accolade
    	IOperation soustraction = (x, y) -> x - y;
        
        // Avec 'return' et les accolades
    	IOperation multiplication = (int x, int y) -> { return x *y; };
        
        // Sans 'return' et sans les accolades
    	IOperation division = (int x, int y) -> x / y;
        
        // Appel de la methode statique et transmission des objet en parametre a cette methode
    	System.out.println("15 + 20 = " + calculer(15, 20, addition));
    	System.out.println("15 - 20 = " + calculer(15, 20, soustraction));
    	System.out.println("15 * 20 = " + calculer(15, 20, multiplication));
    	System.out.println("15 / 20 = " + calculer(15, 20, division));
    }
}