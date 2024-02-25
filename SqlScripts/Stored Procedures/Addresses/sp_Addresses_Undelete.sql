CREATE PROCEDURE sp_Adresses_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE addresses
        SET
            is_deleted = false
    WHERE id = in_id;
END