CREATE PROCEDURE sp_Email_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM email WHERE id = in_id;
END