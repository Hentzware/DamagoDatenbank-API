CREATE PROCEDURE sp_PersonSchoolClass_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_school_class WHERE id = in_id;
END