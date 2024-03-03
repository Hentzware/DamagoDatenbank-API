CREATE PROCEDURE sp_Module_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE module
        SET is_deleted = false
    WHERE id = in_id;
END