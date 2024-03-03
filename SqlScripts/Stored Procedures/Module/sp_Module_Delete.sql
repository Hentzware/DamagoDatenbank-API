CREATE PROCEDURE sp_Module_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE module
        SET is_deleted = true
    WHERE id = in_id;
END