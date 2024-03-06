CREATE PROCEDURE sp_LocationSchoolClass_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE locationSchoolClass SET is_deleted = false WHERE id = in_id;
END