CREATE PROCEDURE sp_LocationSchoolClass_Update (IN in_id varchar(36), IN in_placeholder varchar(100))
BEGIN
    UPDATE locationSchoolClass
        SET
            placeholder = IF (in_placeholder IS NOT NULL, in_placeholder, placeholder)
    WHERE id = in_id;
END