CREATE PROCEDURE sp_Person_Add (IN in_last_name VARCHAR(100), IN in_first_name VARCHAR(100), IN in_birthdate DATE, OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person (id, last_name, first_name, birthdate, is_deleted)
    VALUES (out_id, in_last_name, in_first_name, in_birthdate, false);
END