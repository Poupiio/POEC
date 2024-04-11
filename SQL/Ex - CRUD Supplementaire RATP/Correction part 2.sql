USE ratp;

-- QUESTION 11 : Les stations qui ont une correspondance avec la ligne A
/* SELECT station FROM `2021`
	WHERE connection_1 = 'A'
	OR connection_2 = 'A'
	OR connection_3 = 'A'
	OR connection_4 = 'A'
	OR connection_5 = 'A'
; */
SELECT station FROM `2021` WHERE 'A' IN (connection_1, connection_2, connection_3, connection_4, connection_5);

-- QUESTION 12 : Toutes les informations concernant la ville de Gagny
SELECT * FROM `2021` WHERE city = 'Gagny';

/* QUESTION 13 : Toutes les stations de la ligne 14 sur la même ligne
	(résultat attendu "station ligne 14 olympiades, saint-lazare, marie de saint-ouen, pont cardinet, …) */
SELECT GROUP_CONCAT(station) AS "stations ligne 14" FROM `2021`
	WHERE 14 IN (connection_1, connection_2, connection_3, connection_4, connection_5)
;

-- QUESTION 14 : Les 5 stations de la ligne de la ligne 1 les plus fréquentées.
SELECT station, trafic FROM `2021`
	WHERE 1 IN (connection_1, connection_2, connection_3, connection_4, connection_5)
	ORDER BY trafic DESC
	LIMIT 5
;

-- BONUS
-- La moyenne de la fréquentation des stations dans le 13ème arrondissement de Paris
SELECT AVG(trafic) AS "trafic moyen" FROM `2021`
	WHERE paris_district = 13
;

-- Toutes les villes différentes de Paris
SELECT DISTINCT city FROM `2021` WHERE city != 'Paris';

-- Les stations qui ont le mot "mairie" ou "ville" dans leur nom
SELECT station FROM `2021`
	WHERE LOWER(station) LIKE '%mairie%'
	OR LOWER(station) LIKE '%ville%';
;