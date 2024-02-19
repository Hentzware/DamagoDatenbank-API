CREATE PROCEDURE sp_Classes_Get ()
BEGIN
    SELECT * FROM klassen WHERE is_deleted = false;
END