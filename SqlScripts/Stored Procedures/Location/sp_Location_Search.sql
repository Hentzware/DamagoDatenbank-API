CREATE PROCEDURE sp_Location_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM location
        WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END