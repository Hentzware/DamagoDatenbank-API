CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_GetById`(in in_id varchar(36))
BEGIN
    SELECT * FROM Emails WHERE Id = in_id;
END