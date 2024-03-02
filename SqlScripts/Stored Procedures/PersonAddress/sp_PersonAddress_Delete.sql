CREATE PROCEDURE sp_PersonAddress_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE person_address SET is_deleted = true WHERE id = in_id;
END