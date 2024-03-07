CREATE PROCEDURE sp_PersonSchoolClass_Search (IN in_personId VARCHAR(36), IN in_school_class_id VARCHAR(36))
BEGIN
    SELECT * FROM person_school_class
        WHERE (person_id LIKE in_personId OR in_personId IS NULL)
          AND (school_class_id LIKE in_school_class_id OR in_school_class_id IS NULL);
END