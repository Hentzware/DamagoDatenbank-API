CREATE PROCEDURE sp_Inventar_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE Inventar SET IsDeleted = false WHERE Id = in_id;
END