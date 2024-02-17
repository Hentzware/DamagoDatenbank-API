 CREATE PROCEDURE sp_PersonRole_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_rolleId varchar(36))
 BEGIN
    UPDATE PersonRolle
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            RolleId = IF (in_rolleId IS NOT NULL, in_rolleId, RolleId)
     WHERE Id = in_id;
 END