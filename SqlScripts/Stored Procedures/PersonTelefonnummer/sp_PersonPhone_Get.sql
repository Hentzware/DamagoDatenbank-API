CREATE PROCEDURE sp_PersonPhone_Get ()
BEGIN
    SELECT * FROM PersonTelefonnummer WHERE IsDeleted = false;
END