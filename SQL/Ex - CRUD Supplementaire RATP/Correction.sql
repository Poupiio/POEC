USE ratp;
-- Pour l'année 2021

-- QUESTION 1 : Quelle est la station qui comptabilise le plus de trafic ?
SELECT station FROM `2021` ORDER BY trafic DESC LIMIT 1;

-- QUESTION 2 : Quelle est la station qui comptabilise le moins de trafic ?
SELECT station FROM `2021` ORDER BY trafic ASC LIMIT 1;

-- QUESTION 3 : Quel est le nombre total du trafic annuel toutes les stations confondues ?
SELECT SUM(trafic) AS trafic_total FROM `2021`;

/* QUESTION 4 : Le nombre total des stations par Arrondissement de Paris dans l'ordre décroissant
	(celui qui en a le plus à celui qui en a le moins) ? */
SELECT COUNT(station) AS nb_total_stations, paris_district
	FROM `2021`
	WHERE paris_district != ''
	GROUP BY paris_district
	ORDER BY COUNT(station) DESC
;

-- QUESTION 5 : Quel est le nombre total des stations de métro ?
SELECT COUNT(station) AS nb_stations_metro FROM `2021` WHERE network = 'Métro';

-- QUESTION 6 : Quel est le nombre total des stations de RER ?
SELECT COUNT(station) AS nb_stations_rer FROM `2021` WHERE network = 'RER';

/* QUESTION 7 : Tous les noms des stations des villes suivantes :
	Bobigny, La courneuve, Saint Denis, Pantin, Montreuil et Bagnolet
	trié par le nom de la ville croissante (de A à Z) */
/* SELECT station FROM `2021`
	WHERE city = 'Bobigny'
	OR city = 'La Coureneuve'
	OR city = 'Saint Denis'
	OR city = 'Pantin'
	OR city = 'Montreuil'
	OR city = 'Bagnolet'
; */
SELECT station, city FROM `2021`
	WHERE city
	IN ('Bobigny', 'La Courneuve', 'Saint Denis', 'Pantin', 'Montreuil', 'Bagnolet')
	ORDER BY city
;

-- QUESTION 8 : Toutes les informations concernant les stations de la ville de Vincennes
SELECT * FROM `2021` WHERE city = 'Vincennes';
	
-- QUESTION 9 : Toutes les stations qui commencent par "porte" triées par ordre décroissant (de Z à A)
SELECT station FROM `2021`
	WHERE station
	LIKE 'porte%'
	ORDER BY station DESC
;

/* QUESTION 10 : Toutes les stations qui un tiret triées par le nom de la ville
	puis le nom de la station de manière croissante (A à Z) */
SELECT station, city FROM `2021`
	WHERE station
	LIKE '%-%'
	ORDER BY city ASC, station ASC
;