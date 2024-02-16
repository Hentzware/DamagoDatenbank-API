CREATE PROCEDURE sp_Persons_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM Personen WHERE Id = in_id;
END