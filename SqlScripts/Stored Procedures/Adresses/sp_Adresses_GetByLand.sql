CREATE PROCEDURE sp_Adresses_GetByLand (IN in_land VARCHAR(100))
BEGIN
    SELECT * FROM Adressen WHERE Land LIKE CONCAT('%', in_land, '%');
END