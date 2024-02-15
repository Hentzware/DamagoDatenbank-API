CREATE PROCEDURE sp_Adresses_GetByStrasse (IN in_strasse VARCHAR(100))
BEGIN
    SELECT * FROM Adressen WHERE Strasse LIKE CONCAT('%', in_strasse, '%');
end;