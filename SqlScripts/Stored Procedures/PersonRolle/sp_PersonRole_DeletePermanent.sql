CREATE PROCEDURE sp_PersonRole_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM PersonRolle WHERE Id = in_id;
END