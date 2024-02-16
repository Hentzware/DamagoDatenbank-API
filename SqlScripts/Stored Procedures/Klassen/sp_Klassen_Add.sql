CREATE PROCEDURE sp_Klassen_Add (IN neu_klasse varchar(100))
BEGIN
    INSERT INTO Klasse (Id, Name, IsDeleted)
        VALUES (UUID(), neu_klasse, false);
END