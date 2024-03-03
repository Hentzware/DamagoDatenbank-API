CREATE PROCEDURE sp_Module_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM module WHERE id = in_id;
END