-- In a real project I would prefer to do this using liquibase

INSERT INTO movie("year", title, studios, producers, winner) SELECT year1, title, studios, producers, winner FROM CSVRead('classpath:movielist.csv', null, 'charset=UTF-8 fieldSeparator=;') ;

-- (cast(cast(("year") as varchar(4)) as integer))