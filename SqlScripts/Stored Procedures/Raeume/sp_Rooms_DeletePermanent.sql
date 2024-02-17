CREATE PROCEDURE sp_Rooms_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM Raeume WHERE Id = in_id;
END