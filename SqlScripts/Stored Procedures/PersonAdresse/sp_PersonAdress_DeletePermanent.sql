CREATE PROCEDURE sp_PersonAdress_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM PersonAdresse WHERE Id = in_id;
END