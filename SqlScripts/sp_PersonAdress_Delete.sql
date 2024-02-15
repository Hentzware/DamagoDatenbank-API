CREATE PROCEDURE sp_PersonAdress_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE PersonAdresse SET IsDeleted = true WHERE Id = in_id;
end;