CREATE PROCEDURE sp_Adress_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE address
        SET
            is_deleted = false
    WHERE id = in_id;
END