CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_GetDeleted`()
BEGIN
    SELECT * FROM Email WHERE IsDeleted = true;
END