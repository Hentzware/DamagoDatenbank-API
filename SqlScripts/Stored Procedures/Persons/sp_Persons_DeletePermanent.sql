CREATE PROCEDURE sp_Persons_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM persons WHERE id = in_id;
END