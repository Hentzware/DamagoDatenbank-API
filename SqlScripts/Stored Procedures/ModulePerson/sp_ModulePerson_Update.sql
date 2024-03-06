CREATE PROCEDURE sp_ModulePerson_Update (IN in_id varchar(36), IN in_placeholder varchar(100))
BEGIN
    UPDATE modulePerson
        SET
            placeholder = IF (in_placeholder IS NOT NULL, in_placeholder, placeholder)
    WHERE id = in_id;
END