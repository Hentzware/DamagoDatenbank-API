CREATE DEFINER=`root`@`%` PROCEDURE `sp_Klasse_Get`()
BEGIN
    SELECT * FROM Klasse WHERE IsDeleted = false;
END