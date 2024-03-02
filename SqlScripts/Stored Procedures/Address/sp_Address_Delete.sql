CREATE PROCEDURE sp_Address_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE address SET is_deleted = true WHERE id = in_id;
END