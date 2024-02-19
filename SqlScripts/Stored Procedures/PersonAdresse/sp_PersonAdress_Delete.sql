CREATE PROCEDURE sp_PersonAdress_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE person_adresse SET is_deleted = true WHERE id = in_id;
END