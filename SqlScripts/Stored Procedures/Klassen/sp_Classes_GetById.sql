CREATE PROCEDURE sp_Classes_GetById (in in_id varchar(36))
BEGIN
    SELECT * FROM klassen WHERE id = in_id;
END