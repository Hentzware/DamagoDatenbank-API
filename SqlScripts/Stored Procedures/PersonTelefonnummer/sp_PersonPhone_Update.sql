 CREATE PROCEDURE sp_PersonPhone_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_telefonnummerId varchar(36))
 BEGIN
    UPDATE person_telefonnummer
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            telefonnummer_id = IF (in_telefonnummerId IS NOT NULL, in_telefonnummerId, telefonnummer_id)
     WHERE id = in_id;
 END