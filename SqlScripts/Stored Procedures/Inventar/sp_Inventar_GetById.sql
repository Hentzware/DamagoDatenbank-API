CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_GetById`(IN in_id varchar(36))
BEGIN
    SELECT * FROM Inventar WHERE Id = in_id;
END