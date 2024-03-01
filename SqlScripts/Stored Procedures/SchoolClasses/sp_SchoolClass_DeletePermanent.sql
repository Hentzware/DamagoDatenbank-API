CREATE PROCEDURE sp_SchoolClass_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM school_class WHERE id = in_id;
END