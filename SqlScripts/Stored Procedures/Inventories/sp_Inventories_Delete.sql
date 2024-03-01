CREATE PROCEDURE sp_Inventories_Delete (IN in_id varchar(36))
BEGIN
    UPDATE inventories SET is_deleted = true WHERE id = in_id;
END