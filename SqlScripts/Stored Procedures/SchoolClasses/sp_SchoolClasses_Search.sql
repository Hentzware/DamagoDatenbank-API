CREATE PROCEDURE sp_SchoolClasses_Search (IN in_name VARCHAR(100))
BEGIN
    SELECT * FROM school_classes
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END