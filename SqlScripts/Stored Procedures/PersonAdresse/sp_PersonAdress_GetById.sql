CREATE PROCEDURE sp_PersonAdress_GetById (IN in_id VARCHAR(36))
BEGIN
    SELECT * FROM person_adresse WHERE id = in_id;
end;