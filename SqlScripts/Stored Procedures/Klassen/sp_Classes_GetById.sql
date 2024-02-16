CREATE PROCEDURE sp_Classes_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM Klasse WHERE Id = in_id;
END