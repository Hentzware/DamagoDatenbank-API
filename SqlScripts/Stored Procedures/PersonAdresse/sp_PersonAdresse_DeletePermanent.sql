CREATE PROCEDURE sp_PersonAdresse_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM PersonAdresse WHERE Id = in_id;
END