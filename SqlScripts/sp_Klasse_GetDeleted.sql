CREATE DEFINER=`root`@`%` PROCEDURE `sp_Klasse_GetDeleted`()
BEGIN
    SELECT * FROM Klasse WHERE IsDeleted = true;
END