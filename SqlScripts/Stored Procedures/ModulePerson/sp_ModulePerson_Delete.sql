CREATE PROCEDURE sp_ModulePerson_Delete (IN in_id varchar(36))
BEGIN
    UPDATE modulePerson SET is_deleted = true WHERE id = in_id;
END