CREATE PROCEDURE sp_Phone_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM phone WHERE id = in_id;
END