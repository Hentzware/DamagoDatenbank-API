CREATE PROCEDURE sp_Locations_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM locations
        WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END