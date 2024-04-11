-- Question 3 : Liste des id et titres de films qui incluent "Action" et "Aventure" dans leur genre :
/* SELECT movies.id, movies.title
	FROM movies
	INNER JOIN movie_category ON movies.id = movie_category.id_movie
	INNER JOIN category ON movie_category.id_category = category.id
	WHERE category.title LIKE '%Adventure%' AND category.title LIKE '%Action%'
;
*/
SELECT movies.id, movies.title
	FROM movies
	INNER JOIN movie_category AS mc_action ON movies.id = mc_action.id_movie
	INNER JOIN category AS action_category ON mc_action.id_category = action_category.id
	INNER JOIN movie_category AS mc_adventure ON movies.id = mc_adventure.id_movie
	INNER JOIN category AS adventure_category ON mc_adventure.id_category = adventure_category.id
	WHERE action_category.title = LOWER('action')
  	AND adventure_category.title = LOWER('adventure')
;