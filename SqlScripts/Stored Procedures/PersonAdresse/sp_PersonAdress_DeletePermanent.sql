CREATE PROCEDURE sp_PersonAdress_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM person_adresse WHERE id = in_id;
END