CREATE PROCEDURE sp_SchoolClasses_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM school_classes WHERE id = in_id;
END