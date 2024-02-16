CREATE PROCEDURE sp_Classes_GetByNr (IN in_nr varchar(100))
BEGIN
    SELECT * FROM Klassen WHERE Nr LIKE CONCAT('%', in_nr, '%') AND IsDeleted = false;
END