/**
 * Exercice JDBC :
 * 
 * Ecrire un programme divise en plusieurs fichiers et dossiers.
 * 
 * Un dossier dao pour la partie de code accedant a la BDD.
 * Un dossier modele pour les objets utilises sous forme de JavaBean.
 * Un dossier main pour le programme principal gerant les menus.
 * Vous pouvez creer d'autres dossiers si vous le juger necessaire.
 * 
 * Creer des fichiers differents selon les besoin,
 * et importer les dans les autres fichiers si necessaire.
 * 
 * Description : 
 * 
 * Creer la base de donnees MySQL si elle n'existe pas. Nommee la comme vous le souhaite.
 * Connectez vous a la BDD et creer les tables de la BDD si elles n'existent pas.
 * Ces tables sont : Utilisateurs, Clients, Fournisseurs et Articles.
 * 
 * La table Utilisateurs correpond aux utilisateurs du programme dans une entreprise.
 * Les Utilisateurs ont un id, un numero d'employe unique, un nom, un prenom, un email
 * un login et un mot de passe.
 * 
 * La table Clients cotiendra les client de l'entreprise. Ils ont un id, un numero unique,
 * un nom, un prenom, un email et une adresse.
 * 
 * La table Fournisseurs correspond aux fournisseurs de l'entreprise.
 * Ils ont un id, un num�ro unique, un nom, un email et une adresse.
 * 
 * La table Article correspond aux articles achete au fournisseurs et vendu aux clients.
 * Ils ont un id, un numero unique, un champs indiquant si c'est un article acheter ou vendu, un nom, une description.
 * 
 * les operations a faire sur les toutes tables de la BDD et a decrire dans les menus sont :
 * la lectures complete.
 * la lecture d'un enregistrement selon l'id.
 * l'ecriture.
 * la modification.
 * la suppression.
 * 
 * Pour les menus, faites un premier menu pour choisir la table sur laquelle on veux faire une operation.
 * Puis un sous-menu corresondant aux differentes operations.
 * 
 * Faites les controles necesaires sur les operations pour eviter les incoherences et les erreur SQL.
 * 
 * Tous les champs de toutes les tables sont obligatoires.
 * 
 * Faire les javadoc pour toutes les methodes et classes.
 */

package cours_exercices.exercices.JDBC;

import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * @author Twixy
 */
public class MenuPrincipal {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "");
			// PARTIE CRÉATION BDD + TABLES
			Statement statement = co.createStatement();
			System.out.println("Création de la BDD 'exercice'");
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS exercice CHARACTER SET utf8;");
			System.out.println("BDD créée avec succès.");
			
			System.out.println("Utilisation de la BDD 'exercice'");
			statement.executeUpdate("use exercice");
			
			System.out.println("Création de la table 'user'");
			statement.executeUpdate("""
            CREATE TABLE IF NOT EXISTS user (
            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
            num_employee INT NOT NULL UNIQUE,
            last_name VARCHAR(50) NOT NULL,
            first_name VARCHAR(50) NOT NULL,
            email VARCHAR(100) NOT NULL,
            login VARCHAR(50) NOT NULL,
            password VARCHAR(50) NOT NULL
            )""");
			System.out.println("Table 'user' créée.");
			System.out.println();
			statement.executeUpdate("""
		            CREATE TABLE IF NOT EXISTS client (
		            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		            unique_id INT NOT NULL UNIQUE,
		            last_name VARCHAR(50) NOT NULL,
		            first_name VARCHAR(50) NOT NULL,
		            email VARCHAR(100) NOT NULL,
		            address VARCHAR(255)
		            )""");
			System.out.println("Table 'client' créée.");
			System.out.println();
			statement.executeUpdate("""
		            CREATE TABLE IF NOT EXISTS supplier (
		            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		            unique_num INT NOT NULL UNIQUE,
		            name VARCHAR(100) NOT NULL,
		            email VARCHAR(100) NOT NULL,
		            address VARCHAR(255)
		            )""");
			System.out.println("Table 'supplier' créée.");
			System.out.println();
			statement.executeUpdate("""
		            CREATE TABLE IF NOT EXISTS article (
		            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		            unique_num INT NOT NULL UNIQUE,
		            is_sold BOOLEAN NOT NULL,
		            name VARCHAR(100) NOT NULL,
		            description TEXT NOT NULL
		            )""");
			System.out.println("Table 'article' créée.");
			System.out.println();
			
			
			// PARTIE INSERTION DONNÉES
			// 1. Ajout de données dans la table 'user'
			// statement.executeUpdate("INSERT INTO user VALUES (DEFAULT, 1, 'Nom de famille', 'Prénom', 'monemail@emai.com', 'Mon login', 'Mon password')");
			System.out.println("Données ajoutées à 'user'.");
			
			// 2. Ajout de données dans la table 'client'
			// statement.executeUpdate("INSERT INTO client VALUES (DEFAULT, 1, 'Nom de famille', 'Prénom', 'monemail@emai.com', 'Mon adresse')");
			System.out.println("Données ajoutées à 'client'.");
			
			// 3. Ajout de données dans la table 'supplier'
			// statement.executeUpdate("INSERT INTO supplier VALUES (DEFAULT, 1, 'Nom du fournisseur', 'monemail@emai.com', 'Mon adresse')");
			System.out.println("Données ajoutées à 'supplier'.");
			
			// 4. Ajout de données dans la table 'article'
			// statement.executeUpdate("INSERT INTO article VALUES (DEFAULT, 1, 1, 'Nom de l''article', 'Ceci est une description de l''article')");
			System.out.println("Données ajoutées à 'article'.");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
	
}
