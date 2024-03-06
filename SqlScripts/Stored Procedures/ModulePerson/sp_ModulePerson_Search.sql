CREATE PROCEDURE sp_ModulePerson_Search (IN in_placeholder VARCHAR(100))
BEGIN
    SELECT * FROM modulePerson
    WHERE (placeholder LIKE CONCAT('%', in_placeholder, '%') OR in_placeholder IS NULL);
END