CREATE PROCEDURE sp_Role_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM role
        WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END