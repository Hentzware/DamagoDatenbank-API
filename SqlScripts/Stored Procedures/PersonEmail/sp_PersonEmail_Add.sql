CREATE PROCEDURE sp_PersonEmail_Add (IN in_personId varchar(36), IN in_email varchar(36))
BEGIN
    INSERT INTO PersonEmail (Id, PersonId, EmailId, IsDeleted)
        VALUES (UUID(), in_personId, in_email, false);
END