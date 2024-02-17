CREATE PROCEDURE sp_PersonRole_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM PersonRolle WHERE Id = in_id;
end;