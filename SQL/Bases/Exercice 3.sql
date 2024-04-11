DROP TABLE IF EXISTS etudiants;
DROP TABLE if EXISTS classes;

CREATE TABLE IF NOT EXISTS classes (
	id_classe INT AUTO_INCREMENT PRIMARY KEY,
	nom_classe VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS etudiants (
	id_etudiant INT AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(50),
	prenom VARCHAR(50),
	id_classe INT,
	FOREIGN KEY (id_classe) REFERENCES classes(id_classe)
);