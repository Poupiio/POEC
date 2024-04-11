/**
 * Exemple sur les Fichiers
 */

package cours_exercices.cours;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.Serializable;
import java.io.Writer;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.Reader;

/** 
 * Classe pour ecrire un objet dans un fichier binaire.
 */
class Point implements Serializable {
	private static final long serialVersionUID = 4742924545474768166L;
	private int x;
	private int y;
 
	// Constructeurs.
	Point() {
		this.x = 0;
		this.y = 0;
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Getters.
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}


/**
 * Classe principale.
 */
public class FichiersIO {
	// Constante pour definir le dossier de stockage.
	private static final String CHEMIN = "./src/cours_exercices/cours/Fichiers/";
	
	// Creation d'un dossier s'il n'existe pas.
	public static void creationDossier() {
		File f = new File(CHEMIN);
		
		// si le chemin n'existe pas
		if (!f.exists()) {
			if (f.mkdirs()) System.out.println("Dossier créé. \n");
			else System.out.println("Problème à la création du dossier. \n");
		}
		
	}
	
	// Lecture du chemin d'un fichier.
	public static void lectureChemin() {
		// Creation d'un objet File.
		File ft = new File(CHEMIN + "MonFichier.txt");
		System.out.println("Lecture infos emplacement du fichier");
		
		// Utilisation des methodes de la classe File.
		System.out.println(ft.getName());
		System.out.println(ft.getParent());
		System.out.println(ft.getPath());
		
		// Acces disque pour obtenir le chemin complet.
		try {
			System.out.println(ft.getCanonicalPath());
		} catch (IOException ioe) {
			System.out.println("Problème d'accès au chemin complet.");
		}
		
		System.out.println();
	}

	
	// Ecriture d'un fichier texte avec BufferedWriter. 
	public static void ecritureBufferedFichierText() {
		
		// Creation d'un objet File.
		File ft = new File(CHEMIN + "MonFichier.txt");
		System.out.println("Ecriture Buffered Fichier Texte");
		
		// try with ressource lance un flush() à la fermeture de la ressource
		// true signifie en mode ajout au fichier existant
		// par defaut c'est false, on ecrase le fichier existant.
		try (Writer w = new FileWriter(ft, true);
			BufferedWriter bw = new BufferedWriter(w);) {
			
			// Ecrit le texte.
			bw.write("Hello World");
		
			// Fait un retour chariot.
			bw.newLine();
			
		} catch (IOException ioe) {
			System.out.println("Erreur écriture fichier texte buffered.");
		}
		
	}
	
	// Lecture d'un fichier texte.
    public static void lectureFichierTexte() {
        // Creation d'un objet File.
        File ft = new File(CHEMIN + "MonFichier.txt");
        System.out.println("lecture fichier texte.");
        
        // Creer un objet de lecture de fichier texte.
        try (Reader r = new FileReader(ft)){
            char[] chars = new char[1024];
           
            // StringBuilder est une classe qui enveloppe un tableau de caracteres
            // on peut rajouter des caracteres autant qu'on veut.
            // StringBuilder s'occupe de gerer l'espace en memoire necessaire.
            // Comme une List<char>.
            StringBuilder sb = new StringBuilder();
           
            // Lecture de 1024 caractères ou moins.
            int n = r.read(chars);
           
            // S'il reste des caractères à lire.
            while (n > -1) {
                // Ajoute les n caratactères lus de ma variable chars.
                sb.append(chars, 0, n);
                
                // Lecture de 1024 caractères ou moins.
                n = r.read(chars);
            }
            
            // Affiche le contenu du StringBuffer grâce à toString().
            System.out.println(sb.toString());
        } catch (IOException e) {
            System.out.println("erreur lecture fichier texte.");
        }
    }

	
	// Lecture d'un fichier texte avec BufferedReader.
    public static void lectureBufferedFichierTexte() {
        // Création d'un objet File.
        File ft = new File(CHEMIN + "MonFichier.txt");
        System.out.println("lecture Buffered fichier texte.");
 
        // Créer un objet de lecture de fichier texte.
        try (Reader r = new FileReader(ft);
             BufferedReader br = new BufferedReader(r);
             LineNumberReader lnr = new LineNumberReader(br)) {
 
            // Lecture de la premiere ligne.
            System.out.println(lnr.readLine());
            
            // Initialisation à 1 après la première ligne.
            lnr.setLineNumber(1);
           
            // Lecture des lignes restantes.
            // Sans Stream.
            StringBuilder sb = new StringBuilder();
            String line;
           
            while ((line = lnr.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
             }
           
            System.out.println(sb.toString());
           
            // Avec Stream retourne vide si lnr est lue avant.
            System.out.println(lnr.lines().collect(Collectors.joining(System.lineSeparator())));
           
            // Lecture du nombre total de lignes a la fin de la boucle.
            System.out.println("Nombre total de lignes lues : " + lnr.getLineNumber());
            
        } catch (IOException ioe) {
            System.out.println("Erreur lecture fichier texte Buffered.");
        }
    }
	
    
  
	// Ecriture d'un fichier binaire.
			// Creation d'un tableau de byte à partir d'un texte.
			
			// Ecriture de tableau dans le fichier.

	
	// Ecriture d'un fichier binaire avec decorateur BufferedOutputStream.
			// Creation d'un tableau de byte encode en UTF-8 à partir d'un texte.
			// UTF-8 est la valeur par defaut de l'encodage.
			
			// Ecriture de tableau dans le fichier.

	
	// Lecture d'un fichier binaire avec decorateur BufferedInputStream.
			
			// Creation d'un tableau de byte.
			
			// Je lis les 1024 premiers octets. 
			
			// On continue s'il en reste.

				// J'ecrit les octets dans le ByteArraysOutputStream.

				// Je lis les octets suivants. 

			// Je flush les derniers octets.

			// Je copie dans fichierLu le contenu du baos.
			
			// Conversion de fichierLu en bytes vers un String pour pouvoir l'afficher
			// en utilisant l'encodage standard UTF-8.

	
	// Ecriture d'un fichier binaire avec decorateur DataOutputStream.
			// Ecriture dans le fichier avec DataOutputStream.

			// Ecriture avec BufferedOutStream.

	
	// Lecture d'un fichier binaire avec decorateur DataInputStream.

			// ByteArrayOutputStream a son equivalent Texte : CharArrayOutputStream.
			
			// Creation d'un tableau de byte pour recuperer la parti buffered.
			
			// Lecture et affichage du int.
			
			// Lecture et affichage du string.
			
			// Je lis les 1024 premiers octets du buffered.
			
			// On continue s'il en reste.
				// J'ecrit les octets dans le ByteArraysOutputStream.
				
				// Je lis les octets suivants.

			// Je flush les derniers octets.

			// Je copie dans fichierLu le contenu du baos.

			
			// Conversion de fichierLu en bytes vers un String pour pouvoir l'afficher
			// en utilisant l'encodage standard UTF-8.

	
	// Ecriture d'objet dans un fichier binaire avec decorateur ObjectOutputStream.
			// Creation d'un objet.
			
			// Ecriture de l'objet dans le fichier avec ObjectOutputStream.

	
	// Lecture d'objet a partir d'un fichier binaire avec decorateur ObjectInputStream.
			// Creation d'un objet.
			
			// Lecture et affichage de l'objet Point.
			// Retourne ClassNotFoundException si la classe retournee est fausse.

	
	// Methode principale. 
	public static void main(String[] args) {
		creationDossier();
		lectureChemin();
		ecritureBufferedFichierText();
		lectureFichierTexte();
		lectureBufferedFichierTexte();
	}
}
