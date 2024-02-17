CREATE PROCEDURE sp_Phones_GetDeleted ()
BEGIN
    SELECT * FROM Telefonnummern WHERE IsDeleted = true;
END