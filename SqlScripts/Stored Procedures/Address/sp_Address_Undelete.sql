CREATE PROCEDURE sp_Address_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE address
        SET
            is_deleted = false
    WHERE id = in_id;
END