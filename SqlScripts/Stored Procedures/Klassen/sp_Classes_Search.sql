CREATE PROCEDURE sp_Classes_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM klassen
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END