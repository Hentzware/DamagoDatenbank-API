CREATE PROCEDURE sp_Locations_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM Standorte WHERE Id = in_id;
end;