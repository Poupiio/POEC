-- Question 2 : La succursale la plus populaire
SELECT response AS location, COUNT(*) AS total FROM survey_data
	WHERE response IN ('Fruitville', 'Farmingburg', 'Cliffmont', 'Parkdale') 
	GROUP BY response
	ORDER BY total DESC
;