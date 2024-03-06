CREATE PROCEDURE sp_LocationSchoolClass_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM locationSchoolClass WHERE id = in_id;
END