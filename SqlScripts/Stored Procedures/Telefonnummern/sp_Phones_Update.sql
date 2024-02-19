 CREATE PROCEDURE sp_Phones_Update (IN in_id varchar(36), IN in_telefonnummer varchar(100))
 BEGIN
    UPDATE telefonnummern
        SET
            telefonnummer = IF (in_telefonnummer IS NOT NULL, in_telefonnummer, telefonnummer)
     WHERE id = in_id;
 END