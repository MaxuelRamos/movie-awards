drop table if exists producer_win_interval CASCADE;

create view producer_win_interval as -- in a real database, this would be a materialized view
SELECT p.name AS producer,
       (p_wins.next_win_year - p_wins.win_year) AS win_interval,
       p_wins.win_year AS previous_win,
       p_wins.next_win_year AS FOLLOWING_WIN,
       RANK () OVER (
                     ORDER BY p_wins.next_win_year - p_wins.win_year DESC) rank_number
FROM
  (SELECT p. id AS producer_id,
          m1."year" AS win_year,

     (SELECT m2."year"
      FROM movie m2
      JOIN producer_has_movie pm2 ON pm2.movie_id = m2.id
      AND pm2.producer_id = p.id
      WHERE m2.winner = TRUE
        AND m2.id > m1.id
      ORDER BY m2."year" ASC
      LIMIT 1) AS next_win_year
   FROM movie m1
   JOIN producer_has_movie pm ON pm.movie_id = m1.id
   JOIN producer p ON pm.producer_id = p.id
   WHERE m1.winner = TRUE
   ORDER BY m1."year") AS p_wins
JOIN producer p ON p.id = p_wins.producer_id
WHERE p_wins.next_win_year IS NOT NULL
ORDER BY rank_number;