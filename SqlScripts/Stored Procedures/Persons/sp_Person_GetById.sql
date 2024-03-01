CREATE PROCEDURE sp_Person_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person WHERE id = in_id;
end;