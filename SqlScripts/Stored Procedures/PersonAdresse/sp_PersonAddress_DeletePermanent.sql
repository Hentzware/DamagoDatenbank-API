CREATE PROCEDURE sp_PersonAddress_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_address WHERE id = in_id;
END