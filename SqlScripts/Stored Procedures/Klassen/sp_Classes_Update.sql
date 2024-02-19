CREATE PROCEDURE sp_Classes_Update (IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE klassen
        SET
            name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END