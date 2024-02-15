CREATE DEFINER=`root`@`%` PROCEDURE `sp_PersonEmail_Delete`(IN in_id VARCHAR(36))
BEGIN
   UPDATE PersonEmail SET IsDeleted = true WHERE Id = in_id;
END