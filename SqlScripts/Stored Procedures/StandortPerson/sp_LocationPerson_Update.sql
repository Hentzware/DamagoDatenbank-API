 CREATE PROCEDURE sp_LocationPerson_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_StandortId varchar(36))
 BEGIN
    UPDATE standort_person
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            standort_id = IF (in_StandortId IS NOT NULL, in_StandortId, standort_id)
     WHERE Id = in_id;
 END