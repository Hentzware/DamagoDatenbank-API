CREATE PROCEDURE sp_PersonRole_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_role WHERE id = in_id;
END