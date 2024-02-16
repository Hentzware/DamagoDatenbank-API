CREATE PROCEDURE sp_Inventar_GetByName (IN in_name varchar(36))
BEGIN
    SELECT * FROM Inventar WHERE Name LIKE CONCAT('%', in_name, '%') AND IsDeleted = false;
END