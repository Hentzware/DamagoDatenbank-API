CREATE PROCEDURE sp_Room_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM room WHERE id = in_id;
END