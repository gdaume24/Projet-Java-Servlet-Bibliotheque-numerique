SELECT DB_NAME();
CREATE Table Livres (
	id INT PRIMARY KEY IDENTITY(1, 1),
	titre VARCHAR(255) NOT NULL,
	auteur VARCHAR(255) NOT NULL,
	isbn VARCHAR(50) NOT NULL,
	annee_publication INT,
	genre VARCHAR(100)
);



