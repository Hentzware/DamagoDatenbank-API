CREATE PROCEDURE sp_Adresses_Delete (IN in_id VARCHAR(36))
BEGIN
    UPDATE Adressen SET IsDeleted = true WHERE Id = in_id;
end;