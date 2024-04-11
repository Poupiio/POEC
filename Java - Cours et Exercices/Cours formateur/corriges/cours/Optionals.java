/**
 * Exemple sur Optional
 */

package corriges.cours;

// Import
import java.util.Optional;

/**
 * Classe adresse avec Optional 
 */
class Adresse {
	// Attribut
    private Optional<String> ville;

    // Constructeur
    public Adresse(Optional<String> ville) {
        this.ville = ville;
    }

    // Getter
    public Optional<String> getVille() {
        return this.ville;
    }
}
/**
 * Classe personne avec Optional
 */
class Personne {
	// Attribut
    private Optional<Adresse> adresse;
    
    // Constructeur
    public Personne(Optional<Adresse> adresse) {
        this.adresse = adresse;
    }
    
    // Getter
    public Optional<Adresse> getAdresse() {
    	return this.adresse;
    }
}

/**
 * Classe principale
 */
public class Optionals {
	// Methode principale
	public static void main(String[] args) {
		// Creation d'un Optional vide
		Optional<String> monOptional = Optional.empty();
		System.out.println("mon optional = " + monOptional);
		
		// Creation d'un Optional s'il est vide.
		Optional<String> nom = monOptional.or(() -> Optional.ofNullable("Claire"));		
		System.out.println("nom = " + nom);
		
		// Creation d'un Optional non vide.
		String elem = "Alex";
		monOptional = Optional.of(elem);
		System.out.println("mon optional = " + monOptional);
		
		// Optional d'un element eventuellement null
		// element non null
		Optional<String> o1 = Optional.ofNullable(elem);
		System.out.println(o1.isEmpty());
		System.out.println(o1.isPresent());
	
		// recupere la valeur de la variable
		// si elle est null cela provoque une exception NullPointerException
		System.out.println(o1.get());
		// affiche la variable si elle existe
		o1.ifPresent(System.out::println);
		// affiche la variable si elle existe ou affiche "Optional vide"
		o1.ifPresentOrElse(System.out::println, () -> System.out.println("Optional vide"));

		// element null
		Optional<String> o2 = Optional.ofNullable(null);
		System.out.println(o2.isEmpty());
		System.out.println(o2.isPresent());
		// recupere la valeur de la variable,
		// si elle est null on retourne la valeur indiquee dans le orElse.
		System.out.println(o2.orElse("Claire"));
		// si elle est null on retourne le resultat generer.
		System.out.println(o2.orElseGet(() -> "Claire"));
		
		// levee d'une exception
		System.out.println();
		System.out.println("exception :");
        Optional<String> o3 = Optional.empty();

        try {
            String valeur = o3.orElseThrow(() -> new IllegalStateException("Aucune valeur presente."));
            System.out.println("Valeur : " + valeur);
        }
        catch (IllegalStateException e) {
            System.out.println("Exception attrapee : " + e.getMessage());
        }
        
		// filtre
		System.out.println();
		System.out.println("filtre :");
		Optional<Integer> o4 = Optional.ofNullable(30);
		System.out.println(o4.filter(age -> age > 20).isPresent()); // true
		System.out.println(o4.filter(age -> age > 40).filter(age -> age < 100).isPresent()); // false
		System.out.println(o4.filter(age -> age < 100).isPresent()); // true
		
		// mapping
		System.out.println();
		System.out.println("map :");
		Optional<String> o5 = Optional.ofNullable("Alex");
		System.out.println(o5.map(String::toUpperCase).orElse("Claire"));

        Adresse a = new Adresse(Optional.ofNullable("Paris"));
        Personne p = new Personne(Optional.ofNullable(a));
        // Utilisation de map
        // avec ::
        Optional<String> villeMap = p.getAdresse().map(Adresse::getVille).orElse(Optional.empty());
        // sans ::
        villeMap = p.getAdresse().map(adr -> adr.getVille()).orElse(Optional.empty());

        // Utilisation de flatMap
        // avec ::
        Optional<String> villeFlatMap = p.getAdresse().flatMap(Adresse::getVille);
        //sans ::
        villeFlatMap = p.getAdresse().flatMap(adr -> adr.getVille());
        
        System.out.println("Ville avec map : " + villeMap.orElse("Ville inconnue"));
        System.out.println("Ville avec flatMap : " + villeFlatMap.orElse("Ville inconnue"));
	}
}
