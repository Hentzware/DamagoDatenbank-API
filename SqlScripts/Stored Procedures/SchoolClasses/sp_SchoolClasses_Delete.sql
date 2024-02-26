CREATE PROCEDURE sp_SchoolClasses_Delete (IN in_id varchar(36))
BEGIN
    UPDATE school_classes SET is_deleted = true WHERE id = in_id;
END