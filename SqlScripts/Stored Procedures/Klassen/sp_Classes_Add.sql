CREATE PROCEDURE sp_Classes_Add (IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    INSERT INTO Klasse (Id, Name, Nr, IsDeleted)
        VALUES (UUID(), in_name, in_nr, false);
END