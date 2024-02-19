CREATE PROCEDURE sp_LocationPerson_Add (IN in_personId VARCHAR(36), IN in_StandortId VARCHAR(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO standort_person (id, person_id, standort_id, is_deleted)
    VALUES (out_id, in_personId, in_StandortId, false);
END