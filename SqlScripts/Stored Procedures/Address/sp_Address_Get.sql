CREATE PROCEDURE sp_Address_Get ()
BEGIN
    SELECT * FROM address WHERE is_deleted = false;
END