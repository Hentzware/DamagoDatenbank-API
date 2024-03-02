CREATE PROCEDURE sp_PersonSchoolClass_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_school_class WHERE id = in_id;
end;