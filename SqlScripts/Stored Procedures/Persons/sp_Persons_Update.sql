 CREATE PROCEDURE sp_Persons_Update (IN in_id varchar(36), IN in_last_name varchar(100), IN in_first_name varchar(100), IN in_birthdate date)
 BEGIN
    UPDATE persons
        SET
            last_name = IF (in_last_name IS NOT NULL, in_last_name, last_name),
            first_name = IF (in_first_name IS NOT NULL, in_first_name, first_name),
            birthdate = IF (in_birthdate IS NOT NULL, in_birthdate, birthdate)
     WHERE id = in_id;
 END