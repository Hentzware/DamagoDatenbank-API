CREATE PROCEDURE sp_Adresses_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM Adressen WHERE Id = in_id;
end;