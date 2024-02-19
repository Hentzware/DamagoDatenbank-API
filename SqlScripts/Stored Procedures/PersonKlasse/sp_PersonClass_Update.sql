 CREATE PROCEDURE sp_PersonClass_Update (IN in_id varchar(36), IN in_personId varchar(36), IN in_klasseId varchar(36))
 BEGIN
    UPDATE person_klasse
        SET
            person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
            klasse_id = IF (in_klasseId IS NOT NULL, in_klasseId, klasse_id)
     WHERE id = in_id;
 END