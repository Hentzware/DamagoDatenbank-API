CREATE PROCEDURE sp_Roles_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM rollen WHERE id = in_id;
END