CREATE PROCEDURE sp_PersonEmail_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE PersonEmail SET IsDeleted = false WHERE Id = in_id;
END