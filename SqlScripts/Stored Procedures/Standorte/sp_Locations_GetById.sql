CREATE PROCEDURE sp_Locations_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM standorte WHERE id = in_id;
end;