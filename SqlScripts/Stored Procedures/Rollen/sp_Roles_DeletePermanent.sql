CREATE PROCEDURE sp_Roles_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM Rollen WHERE Id = in_id;
END