CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_GetByName`(IN in_name varchar(36))
BEGIN
    SELECT * FROM Inventar WHERE Name = in_name;
END