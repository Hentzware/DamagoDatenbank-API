CREATE PROCEDURE sp_Phones_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM telefonnummern WHERE id = in_id;
end;