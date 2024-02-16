CREATE PROCEDURE sp_Klassen_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM Klasse WHERE Id = in_id;
END