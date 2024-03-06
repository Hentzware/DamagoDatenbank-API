CREATE PROCEDURE sp_ModuleSchoolClass_Delete (IN in_id varchar(36))
BEGIN
    UPDATE moduleSchoolClass SET is_deleted = true WHERE id = in_id;
END