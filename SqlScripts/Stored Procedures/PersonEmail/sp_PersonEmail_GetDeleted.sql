CREATE PROCEDURE sp_PersonEmail_GetDeleted ()
BEGIN
    SELECT * FROM personEmail WHERE is_deleted = true;
END