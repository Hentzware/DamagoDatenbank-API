 CREATE PROCEDURE sp_Rooms_Update (IN in_id varchar(36), IN in_name varchar(100), IN in_nr varchar(100))
 BEGIN
    UPDATE raeume
        SET
            name = IF (in_name IS NOT NULL, in_name, name),
            nr = IF (in_nr IS NOT NULL, in_nr, nr)
     WHERE id = in_id;
 END