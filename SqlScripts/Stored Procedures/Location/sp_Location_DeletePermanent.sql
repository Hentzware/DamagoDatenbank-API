CREATE PROCEDURE sp_Location_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM location WHERE id = in_id;
END