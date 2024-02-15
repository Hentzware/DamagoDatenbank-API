CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_Update`(IN in_id varchar(36), IN in_name varchar(100), IN in_anzahl int, IN in_isDeleted bool)
BEGIN
    UPDATE Inventar
        SET
            Name = IF (in_name IS NOT NULL, in_name, Name),
            Anzahl = IF (in_anzahl IS NOT NULL, in_anzahl, Anzahl),
            IsDeleted = IF (in_isDeleted IS NOT NULL, in_isDeleted, IsDeleted)
    WHERE Id = in_id;
END