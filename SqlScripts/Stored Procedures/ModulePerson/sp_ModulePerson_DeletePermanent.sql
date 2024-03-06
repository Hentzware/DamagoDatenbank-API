CREATE PROCEDURE sp_ModulePerson_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM modulePerson WHERE id = in_id;
END