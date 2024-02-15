CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_DeletePermanent`(IN in_id varchar(36))
BEGIN
    DELETE FROM Emails WHERE Id = in_id;
END