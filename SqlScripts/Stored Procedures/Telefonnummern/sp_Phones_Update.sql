 CREATE PROCEDURE sp_Phones_Update (IN in_id varchar(36), IN in_telefonnummer varchar(100))
 BEGIN
    UPDATE Telefonnummern
        SET
            Telefonnummer = IF (in_telefonnummer IS NOT NULL, in_telefonnummer, Telefonnummer)
     WHERE Id = in_id;
 END