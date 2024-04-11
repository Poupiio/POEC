-- Question 1 : Afficher le nombre total de réponses pour chaque question
/* SELECT question_text, COUNT(response) FROM survey_data
	WHERE TRIM(question_text) LIKE '1%'
   OR TRIM(question_text) LIKE '2%'
   OR TRIM(question_text) LIKE '3%'
   OR TRIM(question_text) LIKE '4%'
   OR TRIM(question_text) LIKE '5%'
	GROUP BY question_text
	ORDER BY TRIM(question_text) ASC
; */

SELECT question_text, COUNT(response) AS response FROM survey_data
	GROUP BY question_text
	ORDER BY question_text
;