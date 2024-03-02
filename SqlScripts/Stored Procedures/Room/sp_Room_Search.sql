CREATE PROCEDURE sp_Room_Search (IN in_name VARCHAR(100), IN in_nr VARCHAR(100))
BEGIN
    SELECT * FROM room
        WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
          AND (nr LIKE CONCAT('%', in_nr, '%') OR in_nr IS NULL);
END