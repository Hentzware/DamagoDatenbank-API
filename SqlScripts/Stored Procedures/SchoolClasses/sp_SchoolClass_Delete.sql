CREATE PROCEDURE sp_SchoolClass_Delete (IN in_id varchar(36))
BEGIN
    UPDATE school_class SET is_deleted = true WHERE id = in_id;
END