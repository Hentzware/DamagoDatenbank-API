CREATE PROCEDURE sp_PersonLocation_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM PersonStandort WHERE Id = in_id;
END