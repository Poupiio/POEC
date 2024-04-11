CREATE TABLE IF NOT EXISTS dossier_etudiants (
 	id_dossier INT AUTO_INCREMENT PRIMARY KEY,
 	informations VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS etudiants (
	id_etudiant INT AUTO_INCREMENT PRIMARY KEY,
 	nom VARCHAR(50),
 	prenom VARCHAR(50),
 	id_dossier INT,
 	FOREIGN KEY (id_dossier) REFERENCES dossier_etudiants(id_dossier)
);