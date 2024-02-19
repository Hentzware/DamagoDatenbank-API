CREATE PROCEDURE sp_Classes_DeletePermanent (IN in_id varchar(36))
BEGIN
    DELETE FROM klassen WHERE id = in_id;
END