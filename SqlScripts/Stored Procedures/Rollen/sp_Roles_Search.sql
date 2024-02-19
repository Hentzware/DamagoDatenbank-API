CREATE PROCEDURE sp_Roles_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM rollen
        WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END