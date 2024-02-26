CREATE PROCEDURE sp_SchoolClasses_Add (IN in_name varchar(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO school_classes (id, name, is_deleted)
        VALUES (out_id, in_name, false);
END