CREATE PROCEDURE sp_Phones_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM telefonnummern WHERE id = in_id;
END