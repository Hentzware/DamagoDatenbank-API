CREATE PROCEDURE sp_LocationSchoolClass_Delete (IN in_id varchar(36))
BEGIN
    UPDATE locationSchoolClass SET is_deleted = true WHERE id = in_id;
END