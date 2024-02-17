 CREATE PROCEDURE sp_PersonLocation_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_StandortId varchar(36))
 BEGIN
    UPDATE PersonStandort
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            StandortId = IF (in_StandortId IS NOT NULL, in_StandortId, StandortId)
     WHERE Id = in_id;
 END