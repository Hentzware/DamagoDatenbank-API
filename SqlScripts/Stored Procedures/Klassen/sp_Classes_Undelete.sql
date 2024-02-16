CREATE PROCEDURE sp_Classes_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE Klassen SET IsDeleted = false WHERE Id = in_id;
END