CREATE PROCEDURE sp_PersonAdress_Update (IN in_id VARCHAR(36), IN in_personId VARCHAR(36), IN in_adressId VARCHAR(36))
BEGIN
    UPDATE person_adresse
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            adresse_id = IF (in_adressId IS NOT NULL, in_adressId, adresse_id)
    WHERE Id = in_id;
end;