CREATE PROCEDURE sp_Adresses_GetByHausnummer (IN in_hausnummer VARCHAR(100))
BEGIN
    SELECT * FROM Adressen WHERE Hausnummer LIKE CONCAT('%', in_hausnummer, '%');
end;