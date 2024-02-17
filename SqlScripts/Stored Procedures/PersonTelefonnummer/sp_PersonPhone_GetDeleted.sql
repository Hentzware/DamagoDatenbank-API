CREATE PROCEDURE sp_PersonPhone_GetDeleted ()
BEGIN
    SELECT * FROM PersonTelefonnummer WHERE IsDeleted = true;
END