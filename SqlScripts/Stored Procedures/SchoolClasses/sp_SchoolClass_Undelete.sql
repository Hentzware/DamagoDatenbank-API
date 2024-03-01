CREATE PROCEDURE sp_SchoolClass_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE school_class SET is_deleted = false WHERE id = in_id;
END