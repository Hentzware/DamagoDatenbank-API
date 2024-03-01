CREATE PROCEDURE sp_SchoolClass_Update (IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE school_class
        SET
            name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END