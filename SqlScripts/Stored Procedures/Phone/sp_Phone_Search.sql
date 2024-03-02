CREATE PROCEDURE sp_Phone_Search (IN in_phone VARCHAR(100))
BEGIN
    SELECT * FROM phone
        WHERE (phone LIKE CONCAT('%', in_phone, '%') OR in_phone IS NULL);
END