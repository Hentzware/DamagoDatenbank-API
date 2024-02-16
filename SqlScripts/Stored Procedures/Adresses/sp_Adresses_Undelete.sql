CREATE PROCEDURE sp_Adresses_Undelete (IN in_id VARCHAR(36))
BEGIN
    UPDATE Adressen
        SET
            IsDeleted = false
    WHERE Id = in_id;
END