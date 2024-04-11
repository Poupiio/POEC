-- Question 4 : Liste des films dont le titre commence par "The
SELECT title, year
	FROM movies
	WHERE title LIKE 'The%'
;