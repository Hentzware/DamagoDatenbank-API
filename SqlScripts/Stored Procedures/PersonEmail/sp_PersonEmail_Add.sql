CREATE PROCEDURE sp_PersonEmail_Add (IN in_id varchar(36), IN in_email varchar(36))
BEGIN
    INSERT INTO PersonEmail (Id, PersonId, EmailId, IsDeleted)
        VALUES (UUID(), neupersonid, in_email, false);
END