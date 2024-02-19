CREATE PROCEDURE sp_Classes_GetDeleted ()
BEGIN
    SELECT * FROM klassen WHERE is_deleted = true;
END