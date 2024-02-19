CREATE PROCEDURE sp_Phones_Get ()
BEGIN
    SELECT * FROM telefonnummern WHERE is_deleted = false;
END