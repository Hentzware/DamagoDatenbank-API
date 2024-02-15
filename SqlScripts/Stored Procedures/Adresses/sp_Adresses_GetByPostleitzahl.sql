CREATE PROCEDURE sp_Adresses_GetByPostleitzahl (IN in_postleitzahl VARCHAR(100))
BEGIN
    SELECT * FROM Adressen WHERE Postleitzahl LIKE CONCAT('%', in_postleitzahl, '%');
end;