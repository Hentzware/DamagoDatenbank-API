CREATE DEFINER=`root`@`%` PROCEDURE `sp_Klasse_GetById`(in in_id varchar(36))
BEGIN
    SELECT * FROM Klasse WHERE Id = in_id;
END