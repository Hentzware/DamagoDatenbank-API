CREATE PROCEDURE sp_Phone_Get ()
BEGIN
    SELECT * FROM phone WHERE is_deleted = false;
END