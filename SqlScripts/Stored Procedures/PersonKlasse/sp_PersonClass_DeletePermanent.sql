CREATE PROCEDURE sp_PersonClass_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM PersonKlasse WHERE Id = in_id;
END