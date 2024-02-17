CREATE PROCEDURE sp_Classes_Delete (IN in_id varchar(36))
BEGIN
    UPDATE Klassen SET IsDeleted = true WHERE Id = in_id;
END