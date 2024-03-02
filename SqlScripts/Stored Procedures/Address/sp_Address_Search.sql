CREATE PROCEDURE sp_Address_Search (IN in_street VARCHAR(100), IN in_house_number VARCHAR(100), IN in_postal_code VARCHAR(100), IN in_location VARCHAR(100), IN in_country VARCHAR(100))
BEGIN
    SELECT * FROM address
    WHERE (street LIKE CONCAT('%', in_street, '%') OR in_street IS NULL)
      AND (house_number LIKE CONCAT('%', in_house_number, '%') OR in_house_number IS NULL)
      AND (postal_code LIKE CONCAT('%', in_postal_code, '%') OR in_postal_code IS NULL)
      AND (location LIKE CONCAT('%', in_location, '%') OR in_location IS NULL)
      AND (country LIKE CONCAT('%', in_country, '%') OR in_country IS NULL);
END