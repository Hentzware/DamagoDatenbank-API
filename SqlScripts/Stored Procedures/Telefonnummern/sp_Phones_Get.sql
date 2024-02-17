CREATE PROCEDURE sp_Phones_Get ()
BEGIN
    SELECT * FROM Telefonnummern WHERE IsDeleted = false;
END