CREATE PROCEDURE sp_SchoolClass_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM school_class
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END