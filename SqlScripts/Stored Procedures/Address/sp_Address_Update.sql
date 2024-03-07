CREATE PROCEDURE sp_Address_Update (IN in_id VARCHAR(36), IN in_street VARCHAR(100), IN in_house_number VARCHAR(100), IN in_postal_code VARCHAR(100), IN in_location VARCHAR(100), IN in_country VARCHAR(100))
BEGIN
    UPDATE address
        SET
            street = IF (in_street IS NOT NULL, in_street, street),
            house_number = IF (in_house_number IS NOT NULL, in_house_number, house_number),
            postal_code = IF (in_postal_code IS NOT NULL, in_postal_code, postal_code),
            location = IF (in_location IS NOT NULL, in_location, location),
            country = IF (in_country IS NOT NULL, in_country, country)
    WHERE id = in_id;
END