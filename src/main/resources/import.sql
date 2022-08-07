---- In a real project I would prefer to do this using liquibase
--
--INSERT INTO movie("year", title, studios, producers, winner) SELECT year1, title, studios, producers, winner FROM CSVRead('classpath:movielist.csv', null, 'charset=UTF-8 fieldSeparator=;') ;
----
---- (cast(cast(("year") as varchar(4)) as integer))

drop table if exists producer_win_interval CASCADE;

create view producer_win_interval as
SELECT p.name AS producer,
                max(m."year") - min(m."year") AS win_interval,
                min(m."year") AS previous_win,
                max(m."year") AS following_win,
                RANK () OVER (ORDER BY max(m."year") - min(m."year") DESC) rank_number
                FROM producer p
                JOIN producer_has_movie phm ON phm.producer_id = p.id
                JOIN movie m ON m.id = phm.movie_id
                GROUP BY p.name
                having count(phm.movie_id) > 1
                ORDER BY rank_number ASC;



