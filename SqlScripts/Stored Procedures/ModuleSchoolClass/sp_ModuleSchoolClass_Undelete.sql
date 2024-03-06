CREATE PROCEDURE sp_ModuleSchoolClass_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE moduleSchoolClass SET is_deleted = false WHERE id = in_id;
END