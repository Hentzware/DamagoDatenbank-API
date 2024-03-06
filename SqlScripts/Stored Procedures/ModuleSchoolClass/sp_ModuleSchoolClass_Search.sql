CREATE PROCEDURE sp_ModuleSchoolClass_Search (IN in_placeholder VARCHAR(100))
BEGIN
    SELECT * FROM moduleSchoolClass
    WHERE (placeholder LIKE CONCAT('%', in_placeholder, '%') OR in_placeholder IS NULL);
END