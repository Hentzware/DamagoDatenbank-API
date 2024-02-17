CREATE PROCEDURE sp_PersonEmail_Add (IN in_personId varchar(36), IN in_email varchar(36), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO PersonEmail (Id, PersonId, EmailId, IsDeleted)
        VALUES (out_id, in_personId, in_email, false);
END