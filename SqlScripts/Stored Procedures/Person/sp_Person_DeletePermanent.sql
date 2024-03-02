CREATE PROCEDURE sp_Person_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person WHERE id = in_id;
END