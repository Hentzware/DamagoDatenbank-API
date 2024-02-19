CREATE PROCEDURE sp_Adresses_GetDeleted ()
BEGIN
    SELECT * FROM adressen WHERE is_deleted = true;
END