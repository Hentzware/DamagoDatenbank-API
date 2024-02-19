CREATE PROCEDURE sp_Rooms_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM raeume WHERE id = in_id;
END