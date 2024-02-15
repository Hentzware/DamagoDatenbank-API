CREATE PROCEDURE sp_Adresses_GetDeleted ()
BEGIN
    SELECT * FROM Adressen WHERE IsDeleted = true;
end;