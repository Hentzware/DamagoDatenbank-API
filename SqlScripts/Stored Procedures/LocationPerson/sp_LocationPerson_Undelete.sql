CREATE PROCEDURE sp_LocationPerson_Undelete (IN in_id varchar(36))
BEGIN
    UPDATE locationPerson SET is_deleted = false WHERE id = in_id;
END