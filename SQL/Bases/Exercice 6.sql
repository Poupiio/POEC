CREATE TABLE IF NOT EXISTS animal (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(50),
	dadte_naissance DATE,
	poids INT,
	couleur VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS chien (
	id INT AUTO_INCREMENT PRIMARY KEY,
	race VARCHAR(50),
	animal_id INT,
	FOREIGN KEY (animal_id) REFERENCES animal(id)
);

CREATE TABLE IF NOT EXISTS chat (
	id INT AUTO_INCREMENT PRIMARY KEY,
	longueur_poils INT,
	animal_id INT,
	FOREIGN KEY (animal_id) REFERENCES animal(id)
);