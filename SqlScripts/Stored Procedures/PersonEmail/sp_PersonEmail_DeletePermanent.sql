CREATE PROCEDURE sp_PersonEmail_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_email WHERE id = in_id;
END