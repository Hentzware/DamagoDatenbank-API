CREATE PROCEDURE sp_ModuleSchoolClass_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM moduleSchoolClass WHERE id = in_id;
END