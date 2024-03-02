 CREATE PROCEDURE sp_PersonRole_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_role_id varchar(36))
 BEGIN
    UPDATE person_role
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            role_id = IF (in_role_id IS NOT NULL, in_role_id, role_id)
     WHERE id = in_id;
 END