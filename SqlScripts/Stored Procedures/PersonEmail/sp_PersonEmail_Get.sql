CREATE PROCEDURE sp_PersonEmail_Get ()
BEGIN
    SELECT * FROM person_email WHERE is_deleted = false;
END