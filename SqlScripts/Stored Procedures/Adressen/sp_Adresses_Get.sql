CREATE PROCEDURE sp_Adresses_Get ()
BEGIN
    SELECT * FROM adressen WHERE is_deleted = false;
END