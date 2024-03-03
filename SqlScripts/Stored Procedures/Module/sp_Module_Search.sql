CREATE PROCEDURE sp_Module_Search (IN in_name VARCHAR(100), IN in_description VARCHAR(250))
BEGIN
    SELECT * FROM module
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
    AND (description LIKE CONCAT('%', in_description, '%') OR in_description IS NULL);
END