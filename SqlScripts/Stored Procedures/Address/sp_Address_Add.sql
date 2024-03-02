CREATE PROCEDURE sp_Address_Add (IN in_street VARCHAR(100), IN in_house_number VARCHAR(100), IN in_postal_code VARCHAR(100), IN in_location VARCHAR(100), IN in_country VARCHAR(100), OUT out_id VARCHAR(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO address (id, street, house_number, postal_code, location, country, is_deleted)
    VALUES (out_id, in_street, in_house_number, in_postal_code, in_location, in_country, false);
END