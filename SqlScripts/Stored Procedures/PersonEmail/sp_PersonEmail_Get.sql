CREATE PROCEDURE sp_PersonEmail_Get ()
BEGIN
    SELECT * FROM PersonEmail WHERE IsDeleted = false;
END