CREATE PROCEDURE sp_PersonPhone_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE person_phone SET is_deleted = false WHERE id = in_id;
END