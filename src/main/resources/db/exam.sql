CREATE TABLE company (
  id integer NOT NULL,
  name character varying,
  CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person (
  id integer NOT NULL,
  name character varying,
  company_id integer references company(id),
  CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name)
VALUES
	(1, 'Company A'),
  (2, 'Company B'),
  (3, 'Company C'),
	(4, 'Company D'),
  (5, 'Company E');

INSERT INTO person (id, name, company_id)
VALUES
	(1, 'Mary', 1),
	(2, 'Tom', 2),
	(3, 'Jane', 3),
	(4, 'Diane', 4),
	(5, 'John', 4),
	(6, 'Stacy', 5),
	(7, 'Mary', 5);

select p.name, c.name
from person as p
join company c
on p.company_id = c.id and p.company_id != 5
group by p.name, c.name;

SELECT c.name, COUNT(p.id) AS person_count
FROM company c
LEFT JOIN person p ON c.id = p.company_id
GROUP BY c.id, c.name
HAVING COUNT(p.id) = (
    SELECT COUNT(id)
    FROM person
    GROUP BY company_id
    ORDER BY COUNT(id) DESC
    LIMIT 1
);