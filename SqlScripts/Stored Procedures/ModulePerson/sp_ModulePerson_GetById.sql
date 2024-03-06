CREATE PROCEDURE sp_ModulePerson_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM modulePerson WHERE id = in_id;
END