CREATE PROCEDURE sp_SchoolClasses_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE school_classes SET is_deleted = false WHERE id = in_id;
END