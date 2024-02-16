CREATE PROCEDURE sp_Classes_Update (IN in_id varchar(36), IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    UPDATE Klasse
        SET
            Name = IF (in_name IS NOT NULL, in_name, Name),
            Nr = IF (in_nr IS NOT NULL, in_nr, Nr)
    WHERE Id = in_id;
END