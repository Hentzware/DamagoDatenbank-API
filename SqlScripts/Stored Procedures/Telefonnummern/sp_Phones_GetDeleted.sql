CREATE PROCEDURE sp_Phones_GetDeleted ()
BEGIN
    SELECT * FROM telefonnummern WHERE is_deleted = true;
END