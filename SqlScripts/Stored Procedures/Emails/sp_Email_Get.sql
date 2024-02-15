CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_Get`()
BEGIN
    SELECT * FROM Emails WHERE IsDeleted = false;
END