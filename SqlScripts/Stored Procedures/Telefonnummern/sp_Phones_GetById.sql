CREATE PROCEDURE sp_Phones_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM Telefonnummern WHERE Id = in_id;
end;