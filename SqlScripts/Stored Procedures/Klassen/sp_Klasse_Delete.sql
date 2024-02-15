CREATE DEFINER=`root`@`%` PROCEDURE `sp_Klasse_Delete`(IN in_id varchar(36))
BEGIN
    UPDATE Klasse SET IsDeleted = true WHERE Id = in_id;
END