/**
 * Exercice sur Optional
 * 
 * Programme de gestion des etudiants d'une universite. 
 * Chaque etudiant peut avoir un nom, un age et une note moyenne.
 * Ecrire une methode afficherDetailsEtudiant 
 * qui prend en parametre un Optional representant un etudiant 
 * et affiche ses details, tels que le nom, l'age et la note moyenne.
 * Si un etudiant est present, les details doivent etre affiches
 * sinon, un message indiquant que l'etudiant est introuvable doit etre affiche.
 * Ecrire la méthode afficherDetailsEtudiant
 * et un programme principal pour tester votre implementation.
 */

package corriges.exercices.optionals;

// Import
import java.util.Optional;

/**
 * Classe Etudiant
 */
class Etudiant {
	// Attribut
    private final String nom;
    private final int age;
    private final double noteMoyenne;
    
    // Constructeur
    public Etudiant(String nom, int age, double noteMoyenne) {
        this.nom = nom;
        this.age = age;
        this.noteMoyenne = noteMoyenne;
    }

    // Getters
    public String getNom() {
        return this.nom;
    }

    public int getAge() {
        return this.age;
    }

    public double getNoteMoyenne() {
        return this.noteMoyenne;
    }
    
    @Override
    public String toString() {
        return """
        	Nom de l'etudiant          : $nom
        	Age de l'etudiant          : $age
        	Note moyenne de l'etudiant : $moyenne
        	"""
        	.replace("$nom", this.getNom())
        	.replace("$age", String.valueOf(this.getAge()))
        	.replace("$moyenne", String.valueOf(this.getNoteMoyenne()));
    }
}

/**
 * Classe principale
 */
public class ExOptionals {
	// Methode afficherDetailsEtudiant
    public static void afficherDetailsEtudiant(Optional<Etudiant> etudiantOptional) {
        etudiantOptional.ifPresentOrElse( System.out::println,
            // etudiant -> { System.out.println(etudiant); },
        	() -> System.out.println("Etudiant introuvable."));
    }
    
    // Methode principale
	public static void main(String[] args) {
		// Creation d'etudiants
        Etudiant etudiant1 = new Etudiant("Alice", 20, 15.5);
        Etudiant etudiant2 = null;
        
        // Affichage des details si l'etudiant n'existe pas
        afficherDetailsEtudiant(Optional.ofNullable(etudiant1));
        afficherDetailsEtudiant(Optional.ofNullable(etudiant2));
	}
}
