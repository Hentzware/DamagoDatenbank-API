CREATE PROCEDURE sp_PersonAdress_Get ()
BEGIN
    SELECT * FROM person_adresse WHERE is_deleted = false;
END