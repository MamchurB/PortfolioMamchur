CREATE TABLE owners (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    age INT
);

CREATE TABLE pets (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(30),
    age INT,
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES owners(id)
);

INSERT INTO owners VALUES
(1, 'Ivan', 'ivan@test.com', 25),
(2, 'Anna', 'anna@test.com', 17),
(3, 'Petro', NULL, 30),
(4, 'Olga', 'olga@test.com', 5);

INSERT INTO pets VALUES
(1, 'Rex', 'DOG', 5, 1),
(2, 'Murka', 'CAT', 3, 1),
(3, 'Tom', 'CAT', 1, 2),
(4, 'Spike', NULL, 2, 3),
(5, 'Ghost', 'DOG', 4, 4);

-- Pets owned by underage owners
SELECT p.*, o.age
FROM pets p
JOIN owners o ON p.owner_id = o.id
WHERE o.age < 18;

-- Pets older than the average age per owner
SELECT p.name AS pet_name
FROM pets p
JOIN (
    SELECT owner_id, AVG(age) AS avg_age
    FROM pets
    GROUP BY owner_id
) avg_pets
ON p.owner_id = avg_pets.owner_id
WHERE p.age > avg_pets.avg_age;

-- Owners with more than one pet
SELECT owner_id, COUNT(*) AS pets_count
FROM pets
GROUP BY owner_id
HAVING COUNT(*) > 1;