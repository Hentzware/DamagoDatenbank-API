CREATE PROCEDURE sp_SchoolClasses_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM school_classes WHERE id = in_id;
END