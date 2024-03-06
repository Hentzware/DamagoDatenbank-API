CREATE PROCEDURE sp_ModulePerson_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE modulePerson SET is_deleted = false WHERE id = in_id;
END