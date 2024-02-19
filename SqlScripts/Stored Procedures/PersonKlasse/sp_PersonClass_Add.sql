CREATE PROCEDURE sp_PersonClass_Add (IN in_personId VARCHAR(36), IN in_klasseId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_klasse (id, person_id, klasse_id, is_deleted)
    VALUES (out_id, in_personId, in_klasseId, false);
END