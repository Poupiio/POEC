/**
 * Exercice sur les constructeurs
 */

package cours_exercices.cours;

// Classe Maison
class Maison {
	
	// Proprietes
	private String materiau;
	private Integer surface;
	private BlocPorte blocPorte;
	
	// Constructeurs
	public Maison() {
		this.materiau = "Plastique";
		this.surface = 500;
		this.blocPorte = new BlocPorte(200, 75);
	}
	
	public Maison(String materiau) {
		this(materiau, 100);	// j'appelle le constructeur à 2 paramètres pour lui passer une valeur par défaut pour la 								surface
	}
	
	public Maison(Integer surface) {
		this("Plastique", surface);		// j'appelle le constructeur à 2 paramètres pour lui passer une valeur par défaut 										pour le matériau
	}
	
	public Maison(String materiau, Integer surface) {
		this.materiau = materiau;
		this.surface = surface;
	}
	
	// Constructeur appelant le constructeur de la classe BlocPorte. 
	public Maison(String materiau, Integer surface, Integer hauteur, Integer largeur) {
		this(materiau, surface);	// J'appelle le constructeur à 2 paramètres de Maison
		this.blocPorte = new BlocPorte(hauteur, largeur);	// J'appelle le constructeur de BlocPorte à 2 paramètres
	}
	
	// Getters
	public String getMateriau() {
		return this.materiau;
	}
	
	public Integer getSurface() {
		return this.surface;
	}
	
	public BlocPorte getBlocPorte() {
		return this.blocPorte;
	}
	
	// Setters
	public void setMateriau(String materiau){
		this.materiau = materiau;
	}
	
	public void setSurface(Integer surface){
		this.surface = surface;
	}
	
	public void setBlocPorte(BlocPorte blocPorte){
		this.blocPorte = blocPorte;
	}
	
}


// Classe BlocPorte
class BlocPorte {
	// Proprietes
	private Integer hauteur;
	private Integer largeur;
	
	// Constructeur
	public BlocPorte(Integer hauteur, Integer largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	// Getters
	public Integer getLargeur() {
		return this.largeur;
	}
	
	public Integer getHauteur() {
		return this.hauteur;
	}
	
	// Setters
	public void setLargeur(Integer largeur){
		this.largeur = largeur;
	}
	
	public void setHauteur(Integer hauteur){
		this.hauteur = hauteur;
	}
	
}


// Classe principale
public class Constructeurs {
	
	// Methode principale
    public static void main(String[] args) {
    	
    	Maison petite = new Maison("Brique", 60);
    	System.out.println(petite.getSurface());
    	System.out.println(petite.getMateriau());
    	
    	System.out.println();
    	
    	Maison moyenne = new Maison("Pierre");
    	System.out.println(moyenne.getSurface());
    	System.out.println(moyenne.getMateriau());
    	
    	System.out.println();
    	
    	Maison grande = new Maison("Bois", 300, 200, 80);
    	System.out.println(grande.getMateriau());
    	System.out.println(grande.getSurface());
    	System.out.println(grande.getBlocPorte().getHauteur());
    	System.out.println(grande.getBlocPorte().getLargeur());
    	
    	System.out.println();
    	
    	// Maison sans paramètre (= par défaut)
    	Maison m = new Maison();
    	System.out.println(m.getMateriau());
    	System.out.println(m.getSurface());
    	System.out.println(m.getBlocPorte().getHauteur());
    	System.out.println(m.getBlocPorte().getLargeur());
    }
}