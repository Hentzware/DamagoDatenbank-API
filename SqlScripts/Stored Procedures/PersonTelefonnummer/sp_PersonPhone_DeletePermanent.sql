CREATE PROCEDURE sp_PersonPhone_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM PersonTelefonnummer WHERE Id = in_id;
END