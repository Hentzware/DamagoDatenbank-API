CREATE PROCEDURE sp_ModuleSchoolClass_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM moduleSchoolClass WHERE id = in_id;
END