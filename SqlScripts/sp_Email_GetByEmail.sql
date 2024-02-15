CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_GetByEmail`(in in_email varchar(36))
BEGIN
    SELECT * FROM Emails WHERE Email = in_email;
END