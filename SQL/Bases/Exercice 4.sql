CREATE TABLE IF NOT EXISTS professeurs (
	id_professeur INT AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(50),
	prenom VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS classes (
	id_classe INT AUTO_INCREMENT PRIMARY KEY,
	nom_classe VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS cours (
	id_professeur INT PRIMARY KEY,
	id_classe INT PRIMARY KEY,
	FOREIGN KEY (id_professeur) REFERENCES professeurs(id_professeur),
	FOREIGN KEY (id_classe) REFERENCES classes(id_classe)
);