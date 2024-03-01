CREATE PROCEDURE sp_Addresses_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE addresses SET is_deleted = true WHERE id = in_id;
END