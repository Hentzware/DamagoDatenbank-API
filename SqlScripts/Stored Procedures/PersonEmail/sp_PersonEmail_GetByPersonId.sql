CREATE PROCEDURE sp_PersonEmail_GetByPersonId (IN in_personId VARCHAR(36))
BEGIN
    SELECT * FROM PersonEmail WHERE PersonId = in_personId AND IsDeleted = false;
END