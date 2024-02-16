CREATE PROCEDURE sp_Adresses_GetByOrt (IN in_ort VARCHAR(100))
BEGIN
    SELECT * FROM Adressen WHERE Ort LIKE CONCAT('%', in_ort, '%');
END