CREATE PROCEDURE sp_Classes_Update (IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE Klassen
        SET
            Name = IF (in_name IS NOT NULL, in_name, Name)
    WHERE Id = in_id;
END