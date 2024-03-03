CREATE PROCEDURE sp_Module_Update (IN in_id VARCHAR(36), IN in_name VARCHAR(100), IN in_description VARCHAR(250))
BEGIN
    UPDATE module
        SET
            name = IF (in_name IS NOT NULL, in_name, name),
            description = IF (in_description IS NOT NULL, in_description, description);
END