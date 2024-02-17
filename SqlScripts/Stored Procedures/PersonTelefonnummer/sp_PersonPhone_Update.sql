 CREATE PROCEDURE sp_PersonPhone_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_telefonnummerId varchar(36))
 BEGIN
    UPDATE PersonTelefonnummer
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            TelefonnummerId = IF (in_telefonnummerId IS NOT NULL, in_telefonnummerId, TelefonnummerId)
     WHERE Id = in_id;
 END