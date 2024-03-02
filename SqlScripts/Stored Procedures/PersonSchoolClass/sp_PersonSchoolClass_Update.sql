 CREATE PROCEDURE sp_PersonSchoolClass_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_school_class_id varchar(36))
 BEGIN
    UPDATE person_school_class
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            school_class_id = IF (in_school_class_id IS NOT NULL, in_school_class_id, school_class_id)
     WHERE id = in_id;
 END