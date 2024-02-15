CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_Delete`(IN in_id varchar(36))
BEGIN
    UPDATE Emails SET IsDeleted = true WHERE Id = in_id;
END