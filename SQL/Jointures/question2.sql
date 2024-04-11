-- Question 2 : Liste des films qui incluent le genre "Drama"
SELECT movies.title, movie_category.id_movie
	FROM movies
	INNER JOIN movie_category ON movies.id = movie_category.id_movie
	INNER JOIN category ON movie_category.id_category = category.id
	WHERE category.title LIKE '%Drama%'
;