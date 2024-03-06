CREATE PROCEDURE sp_PersonSchoolClass_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE personSchoolClass SET is_deleted = false WHERE id = in_id;
END