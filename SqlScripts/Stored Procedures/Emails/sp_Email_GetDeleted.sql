CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_GetDeleted`()
BEGIN
    SELECT * FROM Emails WHERE IsDeleted = true;
END