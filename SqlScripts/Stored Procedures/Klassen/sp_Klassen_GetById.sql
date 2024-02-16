CREATE PROCEDURE sp_Klassen_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM Klasse WHERE Id = in_id;
END