CREATE PROCEDURE sp_PersonAdress_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE person_adresse SET is_deleted = false WHERE id = in_id;
END