CREATE PROCEDURE sp_Adresses_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM Adressen WHERE Id = in_id;
end;