CREATE PROCEDURE sp_PersonAdress_GetByAdressId (IN in_adressId VARCHAR(36))
BEGIN
    SELECT * FROM PersonAdresse WHERE AdresseId = in_adressId;
end;