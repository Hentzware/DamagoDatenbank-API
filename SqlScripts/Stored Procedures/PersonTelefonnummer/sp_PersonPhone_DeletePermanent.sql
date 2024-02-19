CREATE PROCEDURE sp_PersonPhone_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_telefonnummer WHERE id = in_id;
END