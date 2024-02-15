CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_GetDeleted`()
BEGIN
    SELECT * FROM Inventar WHERE IsDeleted = true;
END