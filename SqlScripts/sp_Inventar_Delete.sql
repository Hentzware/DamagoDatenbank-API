CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_Delete`(IN in_id varchar(36))
BEGIN
    UPDATE Inventar SET IsDeleted = true WHERE Id = in_id;
END