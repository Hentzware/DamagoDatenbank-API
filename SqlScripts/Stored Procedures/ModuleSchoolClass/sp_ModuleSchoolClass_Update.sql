CREATE PROCEDURE sp_ModuleSchoolClass_Update (IN in_id varchar(36), IN in_placeholder varchar(100))
BEGIN
    UPDATE moduleSchoolClass
        SET
            placeholder = IF (in_placeholder IS NOT NULL, in_placeholder, placeholder)
    WHERE id = in_id;
END