CREATE DEFINER=`root`@`%` PROCEDURE `sp_PersonEmail_Update`(IN in_id VARCHAR(36), IN in_personId VARCHAR(36), IN in_emailId VARCHAR(36), IN in_isDeleted bool)
BEGIN
    UPDATE PersonEmail
        SET
            PersonId = IF (in_personId IS NOT NULL, in_personId, PersonId),
            EmailId = IF (in_emailId IS NOT NULL, in_emailId, EmailId),
            IsDeleted = IF (in_isDeleted IS NOT NULL, in_isDeleted, IsDeleted)
    WHERE Id = in_id;
end