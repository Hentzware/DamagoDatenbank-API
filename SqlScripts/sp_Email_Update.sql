CREATE DEFINER=`root`@`%` PROCEDURE `sp_Email_Update`(IN in_id varchar(36), IN in_email varchar(100), IN in_isDeleted bool)
BEGIN
    UPDATE Email
        SET
            Email = IF (in_email IS NOT NULL, in_email, Email),
            IsDeleted = IF (in_isDeleted IS NOT NULL, in_isDeleted, IsDeleted)
    WHERE Id = in_id;
END