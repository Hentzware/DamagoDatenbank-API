CREATE PROCEDURE sp_PersonClass_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_klasse WHERE id = in_id;
END