 CREATE PROCEDURE sp_Locations_Update (IN in_id varchar(36), IN in_name varchar(100))
 BEGIN
    UPDATE locations
        SET
            name = IF (in_name IS NOT NULL, in_name, name)
     WHERE id = in_id;
 END