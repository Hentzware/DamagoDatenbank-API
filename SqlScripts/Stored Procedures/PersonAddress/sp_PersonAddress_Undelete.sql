CREATE PROCEDURE sp_PersonAddress_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE person_address SET is_deleted = false WHERE id = in_id;
END