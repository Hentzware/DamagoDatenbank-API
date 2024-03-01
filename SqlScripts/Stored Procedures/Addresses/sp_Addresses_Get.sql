CREATE PROCEDURE sp_Addresses_Get ()
BEGIN
    SELECT * FROM addresses WHERE is_deleted = false;
END