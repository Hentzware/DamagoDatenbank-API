CREATE PROCEDURE sp_Adresses_Get ()
BEGIN
    SELECT * FROM Adressen WHERE IsDeleted = false;
END