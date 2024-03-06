CREATE PROCEDURE sp_LocationSchoolClass_Search (IN in_placeholder VARCHAR(100))
BEGIN
    SELECT * FROM locationSchoolClass
    WHERE (placeholder LIKE CONCAT('%', in_placeholder, '%') OR in_placeholder IS NULL);
END