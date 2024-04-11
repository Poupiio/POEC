package cours_exercices.cours;


import java.sql.*;

// Classe JDBC
public class JDBC {
    public static void main(String args[]) {
        final String str1 = "CREATE DATABASE IF NOT EXISTS Test CHARACTER SET utf8;";
        final String str2 = "use Test";
        final String str3 = """
                            CREATE TABLE IF NOT EXISTS Utilisateurs (
                            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            nom VARCHAR(50) NOT NULL,
                            adresse VARCHAR(255))""";
        final String str4 = "INSERT INTO Utilisateurs VALUES (DEFAULT, 'm2i', 'Tours')";
        final String str5 = "INSERT INTO Utilisateurs VALUES (DEFAULT, 'FI86', 'Poitiers')";
        final String str6 = "INSERT INTO Utilisateurs VALUES (DEFAULT, 'test', 'test')";
        final String str7 = "UPDATE Utilisateurs SET nom = 'M2I Formation' WHERE nom = 'm2i'";
        final String str8 = "DELETE FROM Utilisateurs WHERE nom = 'test'";
        final String str9 = "SELECT * FROM Utilisateurs";
        
        // Suppression du contenu d'une table complete
        // DELETE ne reinitialise pas l'auto incrementation s'il y en a une.
        // DELETE FROM nom_table
        // TRUNCATE permet de reinitialiser l'auto incremenation s'il y en a une.
        // TRUNCATE TABLE nom_table
        final String str0 = "TRUNCATE TABLE Utilisateurs";
        
        final String str10 = "INSERT INTO Utilisateurs VALUES(DEFAULT, ?, ?)";
        final String str11 = "DROP DATABASE test";
        
        try {
            // Etape 1: charger la classe driver
            // Ancienne version
        	// Class.forName("com.mysql.jdbc.Driver");
        
            // Nouvelle version
        	Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Etape 2: creer l'objet de connexion
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "");
            
            // Etape 3: creer l'objet statement
        	Statement statement = conn.createStatement();      
        	
            // Etape 4: executer des requetes
        	System.out.println("Création de la BDD :");
        	statement.executeUpdate(str1);
        	System.out.println("Base de données créée avec succès !");
        	System.out.println();
        	
        	System.out.println("Utilisation de la BDD test :");
        	statement.executeUpdate(str2);
        	System.out.println();
        	
        	System.out.println("Création de la table Utilisateurs :");
        	statement.executeUpdate(str3);
        	System.out.println("La table Utilisateurs a bien été créée.:");
        	System.out.println();
        	
        	System.out.println("Ajout de données dans la table Utilisateurs :");
        	// statement.executeUpdate(str4);
        	// statement.executeUpdate(str5);
        	// statement.executeUpdate(str6);
        	System.out.println("Données ajoutées avec succès :");
        	System.out.println();
        	
        	System.out.println("Modification des données de la table Utilisateurs :");
        	statement.executeUpdate(str7);
        	System.out.println();
        	
        	System.out.println("Suppression d'un utilisateur (test) :");
        	statement.executeUpdate(str8);
        	System.out.println();
            
        	
            // Pour la lecture on utlise la methode executeQuery qui retourne un ResultSet
        	System.out.println("Lecture des données :");
        	ResultSet res = statement.executeQuery(str9);
        	System.out.println();
              
            // Informations sur la table a partir d'un ResultSet
        	ResultSetMetaData resMeta = res.getMetaData();
        	System.out.println("Nom de la table : " + resMeta.getTableName(1));
        	System.out.println("Total des colonnes : " + resMeta.getColumnCount());
        	System.out.println("Nom de la première colonne : " + resMeta.getColumnName(1));
            System.out.println("Type de la première colonne : " + resMeta.getColumnType(1));
            System.out.println("Type SQL de la première colonne : " + resMeta.getColumnTypeName(1));
            System.out.println("Type Java de la première colonne : " + resMeta.getColumnClassName(1));
            System.out.println();
            
            // Parcours du ResultSet
            // Il existe des methodes tel que next, previous, first, last ...
            while (res.next()) {
            	String nom = res.getString("nom");
            	String adresse = res.getString("adresse");
            	
            	System.out.println("Nom : " + nom + " - Adresse : " + adresse);
            	System.out.println();
            }

            System.out.println("Suppression des données de la table Utilisateurs");
            statement.executeUpdate(str0);
            System.out.println();
            
            System.out.println("Insertion de données avec PreparedStatement :");
            PreparedStatement ps = conn.prepareStatement(str10);
            
            // Premier parametre de la requete
            ps.setString(1, "FI86");
            
            // Deuxieme parametre de la requete
            ps.setString(2, "Poitiers");
            
            // Savoir combien d'enregistrements ont été effectués
            int i = ps.executeUpdate();
            System.out.println(i + " enregistrement(s) effectué(s).");
            System.out.println();
            
            
            //////////////////// ROWSET ////////////////////
            // Creation et execution de RowSet
            // Attention il faut preciser le nom de la table dans le setURL
            
            ///////////////// FIN ROWSET //////////////////
            
            // Suppression de la BDD
            
            // Informations sur la connexion
            
            // Etape 5: fermer l'objet de connexion
        	conn.close();
        	
	    } catch (ClassNotFoundException | SQLException e) {
	    	System.out.println(e);
	    }
    }
}