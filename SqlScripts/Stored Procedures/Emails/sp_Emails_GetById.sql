CREATE PROCEDURE sp_Emails_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM emails WHERE id = in_id;
END