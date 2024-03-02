 CREATE PROCEDURE sp_PersonPhone_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_phone_id varchar(36))
 BEGIN
    UPDATE person_phone
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            phone_id = IF (in_phone_id IS NOT NULL, in_phone_id, phone_id)
     WHERE id = in_id;
 END