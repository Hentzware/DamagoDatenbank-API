CREATE PROCEDURE sp_SchoolClass_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM school_class WHERE id = in_id;
END