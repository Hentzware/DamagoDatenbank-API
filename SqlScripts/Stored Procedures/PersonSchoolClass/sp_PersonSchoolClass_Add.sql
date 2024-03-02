CREATE PROCEDURE sp_PersonSchoolClass_Add (IN in_personId VARCHAR(36), IN in_school_class_id VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_school_class (id, person_id, school_class_id, is_deleted)
    VALUES (out_id, in_personId, in_school_class_id, false);
END