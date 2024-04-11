/* Question 3 : Segmentation démographique : segmenter les répondants en fonction de
	a. leur âge,
	b. leur genre
	c. leur revenu du ménage
*/

-- a. Par âge :
SELECT response AS age_group, COUNT(*) FROM survey_data
	WHERE question_text LIKE '%Quel âge%'
	GROUP BY response
	ORDER BY response ASC
;

-- b. Par genre :
SELECT response AS genre, COUNT(*) FROM survey_data
	WHERE question_text LIKE '%genre%'
	GROUP BY response
	ORDER BY response ASC
;

-- c. Par revenu du ménage :
SELECT response AS income_group, COUNT(*) FROM survey_data
	WHERE question_text LIKE '%revenu annuel%'
	GROUP BY response
	ORDER BY response ASC
;