CREATE PROCEDURE sp_LocationSchoolClass_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM locationSchoolClass WHERE id = in_id;
END