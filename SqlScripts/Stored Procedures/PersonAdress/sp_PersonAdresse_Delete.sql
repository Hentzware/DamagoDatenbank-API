CREATE PROCEDURE sp_PersonAdresse_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE PersonAdresse SET IsDeleted = true WHERE Id = in_id;
END