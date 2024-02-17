CREATE PROCEDURE sp_Rooms_Search (IN in_name VARCHAR(100), IN in_nr VARCHAR(100))
BEGIN
    SELECT * FROM Raeume
        WHERE (Name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
          AND (Nr LIKE CONCAT('%', in_nr, '%') OR in_nr IS NULL);
END