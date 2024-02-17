CREATE PROCEDURE sp_Phones_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM Telefonnummern WHERE Id = in_id;
END