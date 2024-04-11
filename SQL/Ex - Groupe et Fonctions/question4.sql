-- Question 4 : Score de Recommandation
SELECT user_id,
	CASE 
		WHEN response >= 9 THEN 'Promoter'
		WHEN response < 9 THEN 'Passive'
	END AS nps_segment
	FROM survey_data
	WHERE question_text LIKE '%recommander%'
	LIMIT 8
;