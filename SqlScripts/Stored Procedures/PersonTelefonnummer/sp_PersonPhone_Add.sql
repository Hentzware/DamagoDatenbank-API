CREATE PROCEDURE sp_PersonPhone_Add (IN in_personId VARCHAR(36), IN in_telefonnummerId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO PersonTelefonnummer (Id, PersonId, TelefonnummerId, IsDeleted)
    VALUES (out_id, in_personId, in_telefonnummerId, false);
END