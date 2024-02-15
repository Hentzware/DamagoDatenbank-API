CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_Get`()
BEGIN
    SELECT * FROM Email WHERE IsDeleted = false;
END