CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_Delete`(IN in_id varchar(36))
BEGIN
    UPDATE Email SET IsDeleted = true WHERE Id = in_id;
END