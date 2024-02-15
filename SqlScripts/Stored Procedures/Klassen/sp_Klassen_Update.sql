CREATE DEFINER=`root`@`%` PROCEDURE `sp_Klassen_Update`(IN in_id varchar(36), IN in_name varchar(100), IN in_isDeleted bool)
BEGIN
    UPDATE Klasse
        SET
            Name = IF (in_name IS NOT NULL, in_name, Name),
            IsDeleted = IF (in_isDeleted IS NOT NULL, in_isDeleted, IsDeleted)
    WHERE Id = in_id;
END