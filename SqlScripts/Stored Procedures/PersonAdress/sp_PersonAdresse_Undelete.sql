CREATE PROCEDURE sp_PersonAdresse_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE PersonAdresse SET IsDeleted = false WHERE Id = in_id;
END