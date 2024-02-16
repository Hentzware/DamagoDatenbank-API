CREATE PROCEDURE sp_Klassen_GetByName (IN in_name varchar(100))
BEGIN
    SELECT * FROM Klassen WHERE Name LIKE CONCAT('%', in_name, '%') AND IsDeleted = false;
END