CREATE PROCEDURE sp_Classes_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM Klassen WHERE Id = in_id;
END