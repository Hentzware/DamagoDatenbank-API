CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_Get`()
BEGIN
    SELECT * FROM Inventar WHERE IsDeleted = false;
END