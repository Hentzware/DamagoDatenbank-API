CREATE DEFINER=`root`@`%` PROCEDURE `sp_Inventar_Add`(IN neu_name varchar(100), IN neu_anzahl varchar(100))
BEGIN
    INSERT INTO Inventar (Id, Name, Anzahl, IsDeleted)
        VALUES (UUID(), neu_name, neu_anzahl, false);
END