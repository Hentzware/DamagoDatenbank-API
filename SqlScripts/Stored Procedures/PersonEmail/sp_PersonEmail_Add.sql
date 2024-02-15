CREATE DEFINER=`root`@`%` PROCEDURE `sp_PersonEmail_Add`(IN neu_personid varchar(36), IN neu_emailid varchar(36))
BEGIN
    INSERT INTO PersonEmail (Id, PersonId, EmailId, IsDeleted)
        VALUES (UUID(), neupersonid, neu_emailid, false);
END