 CREATE PROCEDURE sp_Phone_Update (IN in_id varchar(36), IN in_phone varchar(100))
 BEGIN
    UPDATE phone
        SET
            phone = IF (in_phone IS NOT NULL, in_phone, phone)
     WHERE id = in_id;
 END