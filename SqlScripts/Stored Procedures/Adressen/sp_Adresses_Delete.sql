CREATE PROCEDURE sp_Adresses_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE adressen SET is_deleted = true WHERE id = in_id;
END