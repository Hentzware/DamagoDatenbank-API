CREATE PROCEDURE sp_LocationPerson_DeletePermanent (IN in_id VARCHAR(36))
BEGIN
    DELETE FROM standort_person WHERE id = in_id;
END