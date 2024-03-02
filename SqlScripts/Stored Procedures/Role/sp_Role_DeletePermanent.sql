CREATE PROCEDURE sp_Role_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM role WHERE id = in_id;
END