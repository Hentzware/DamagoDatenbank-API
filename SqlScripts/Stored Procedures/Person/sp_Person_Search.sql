CREATE PROCEDURE sp_Person_Search (IN in_last_name VARCHAR(100), IN in_first_name VARCHAR(100), IN in_birthdate DATE)
BEGIN
    SELECT * FROM person
        WHERE (last_name LIKE CONCAT('%', in_last_name, '%') OR in_last_name IS NULL)
          AND (first_name LIKE CONCAT('%', in_first_name, '%') OR in_first_name IS NULL)
          AND (birthdate = in_birthdate OR in_birthdate IS NULL);
END