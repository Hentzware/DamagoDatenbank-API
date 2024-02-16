CREATE PROCEDURE sp_PersonAdresse_GetByAdressId (IN in_adressId VARCHAR(36))
BEGIN
    SELECT * FROM PersonAdresse WHERE AdresseId = in_adressId;
end;