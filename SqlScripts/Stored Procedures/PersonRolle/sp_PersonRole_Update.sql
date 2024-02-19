 CREATE PROCEDURE sp_PersonRole_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_rolleId varchar(36))
 BEGIN
    UPDATE person_rolle
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            rolle_id = IF (in_rolleId IS NOT NULL, in_rolleId, rolle_id)
     WHERE id = in_id;
 END