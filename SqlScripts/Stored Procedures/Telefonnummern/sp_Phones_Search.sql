CREATE PROCEDURE sp_Phones_Search (IN in_telefonnummer VARCHAR(100))
BEGIN
    SELECT * FROM telefonnummern
        WHERE (telefonnummer LIKE CONCAT('%', in_telefonnummer, '%') OR in_telefonnummer IS NULL);
END