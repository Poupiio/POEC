-- Question 5 : Pourcentage de répondants qui agiraient en tant que promoteurs pour nos produits
/* SELECT AVG(response) AS percentage FROM survey_data
	WHERE response >= 9
; */

SELECT ROUND((SUM(response) / 100)) AS total_reponses FROM survey_data
	WHERE response >= 9
;
/* SELECT response / (SELECT ROUND((SUM(response) / 100)) AS total_reponses FROM survey_data)
	FROM survey_data
		WHERE response >= 9
; */

-- Somme de toutes les réponses / trier réponses >= 9