CREATE PROCEDURE sp_PersonLocation_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_standort WHERE id = in_id;
END