create table if not exists addresses
(
    id           varchar(36)  not null,
    street       varchar(100) not null,
    house_number varchar(100) not null,
    postal_code  varchar(100) not null,
    location     varchar(100) not null,
    country      varchar(100) not null,
    is_deleted   tinyint(1)   not null
);

create table if not exists emails
(
    id         varchar(36)  not null,
    email      varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists inventories
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    amount     int          not null,
    is_deleted tinyint(1)   not null
);

create table if not exists klassen
(
    id         varchar(36)  not null,
    name       varchar(100) null,
    is_deleted tinyint(1)   not null
);

create table if not exists location_person
(
    id          varchar(36) not null,
    location_id varchar(36) not null,
    person_id   varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists locations
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists modul_klasse
(
    id         varchar(36) not null,
    modul_id   varchar(36) not null,
    klasse_id  varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists modul_person
(
    id         varchar(36) not null,
    modul_id   varchar(36) not null,
    person_id  varchar(36) null,
    is_deleted tinyint(1)  not null
);

create table if not exists module
(
    id           varchar(36)  not null,
    name         varchar(100) not null,
    beschreibung varchar(500) null,
    is_deleted   tinyint(1)   not null
);

create table if not exists person_adresse
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    adresse_id varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_email
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    email_id   varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_klasse
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    klasse_id  varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_rolle
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    rolle_id   varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_telefonnummer
(
    id               varchar(36) not null,
    person_id        varchar(36) not null,
    telefonnummer_id varchar(36) not null,
    is_deleted       tinyint(1)  not null
);

create table if not exists persons
(
    id         varchar(36)  not null,
    last_name  varchar(100) not null,
    first_name varchar(100) not null,
    birthdate  date         not null,
    is_deleted tinyint(1)   not null
);

create table if not exists raeume
(
    id         varchar(36)  not null,
    name       varchar(100) null,
    nr         varchar(100) null,
    is_deleted tinyint(1)   not null
);

create table if not exists rollen
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists standort_adresse
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    adresse_id  varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists standort_email
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    email_id    varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists standort_inventar
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    inventar_id varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists standort_klasse
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    klasse_id   varchar(36) null,
    is_deleted  tinyint(1)  not null
);

create table if not exists standort_raum
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    raum_id     varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists standort_telefonnummer
(
    id               varchar(36) not null,
    standort_id      varchar(36) not null,
    telefonnummer_id varchar(36) not null,
    is_deleted       tinyint(1)  not null
);

create table if not exists telefonnummern
(
    id            varchar(36)  not null,
    telefonnummer varchar(100) not null,
    is_deleted    tinyint(1)   not null
);

create table if not exists unterricht
(
    id           varchar(36) not null,
    beginn_datum date        not null,
    ende_datum   date        not null,
    is_deleted   tinyint(1)  not null
);

create procedure sp_Addresses_Add(IN in_street varchar(100), IN in_house_number varchar(100),
                                  IN in_postal_code varchar(100), IN in_location varchar(100),
                                  IN in_country varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO addresses (id, street, house_number, postal_code, location, country, is_deleted)
    VALUES (out_id, in_street, in_house_number, in_postal_code, in_location, in_country, false);
END;

create procedure sp_Addresses_Delete(IN in_id varchar(36))
BEGIN
    UPDATE addresses SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Addresses_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM addresses WHERE id = in_id;
END;

create procedure sp_Addresses_Get()
BEGIN
    SELECT * FROM addresses WHERE is_deleted = false;
END;

create procedure sp_Addresses_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM addresses WHERE id = in_id;
END;

create procedure sp_Addresses_GetDeleted()
BEGIN
    SELECT * FROM addresses WHERE is_deleted = true;
END;

create procedure sp_Addresses_Search(IN in_street varchar(100), IN in_house_number varchar(100),
                                     IN in_postal_code varchar(100), IN in_location varchar(100),
                                     IN in_country varchar(100))
BEGIN
    SELECT * FROM addresses
    WHERE (street LIKE CONCAT('%', in_street, '%') OR in_street IS NULL)
      AND (house_number LIKE CONCAT('%', in_house_number, '%') OR in_house_number IS NULL)
      AND (postal_code LIKE CONCAT('%', in_postal_code, '%') OR in_postal_code IS NULL)
      AND (location LIKE CONCAT('%', in_location, '%') OR in_location IS NULL)
      AND (country LIKE CONCAT('%', in_country, '%') OR in_country IS NULL);
END;

create procedure sp_Adresses_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE addresses
    SET
        is_deleted = false
    WHERE id = in_id;
END;

create procedure sp_Adresses_Update(IN in_id varchar(36), IN in_street varchar(100), IN in_house_number varchar(100),
                                    IN in_postal_code varchar(100), IN in_location varchar(100),
                                    IN in_country varchar(100))
BEGIN
    UPDATE addresses
    SET
        street = IF (in_street IS NOT NULL, in_street, street),
        house_number = IF (in_house_number IS NOT NULL, in_house_number, house_number),
        postal_code = IF (in_postal_code IS NOT NULL, in_postal_code, postal_code),
        location = IF (in_location IS NOT NULL, in_location, location),
        country = IF (in_country IS NOT NULL, in_country, country)
    WHERE id = in_id;
END;

create procedure sp_Classes_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO school_classes (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create procedure sp_Classes_Delete(IN in_id varchar(36))
BEGIN
    UPDATE school_classes SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Classes_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM school_classes WHERE id = in_id;
END;

create procedure sp_Classes_Get()
BEGIN
    SELECT * FROM school_classes WHERE is_deleted = false;
END;

create procedure sp_Classes_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM school_classes WHERE id = in_id;
END;

create procedure sp_Classes_GetDeleted()
BEGIN
    SELECT * FROM school_classes WHERE is_deleted = true;
END;

create procedure sp_Classes_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM school_classes
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create procedure sp_Classes_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE school_classes SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_Classes_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE school_classes
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create procedure sp_Emails_Add(IN in_email varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO emails (id, email, is_deleted)
    VALUES (out_id, in_email, false);
END;

create procedure sp_Emails_Delete(IN in_id varchar(36))
BEGIN
    UPDATE emails SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Emails_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM emails WHERE id = in_id;
END;

create procedure sp_Emails_Get()
BEGIN
    SELECT * FROM emails WHERE is_deleted = false;
END;

create procedure sp_Emails_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM emails WHERE id = in_id;
END;

create procedure sp_Emails_GetDeleted()
BEGIN
    SELECT * FROM emails WHERE is_deleted = true;
END;

create procedure sp_Emails_Search(IN in_email varchar(100))
BEGIN
    SELECT * FROM emails
    WHERE (email LIKE CONCAT('%', in_email, '%') OR in_email IS NULL);
END;

create procedure sp_Emails_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE emails SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_Emails_Update(IN in_id varchar(36), IN in_email varchar(100))
BEGIN
    UPDATE emails
    SET
        email = IF (in_email IS NOT NULL, in_email, email)
    WHERE id = in_id;
END;

create procedure sp_Inventories_Add(IN in_name varchar(100), IN in_amount varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO inventories (id, name, amount, is_deleted)
    VALUES (out_id, in_name, in_amount, false);
END;

create procedure sp_Inventories_Delete(IN in_id varchar(36))
BEGIN
    UPDATE inventories SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Inventories_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM inventories WHERE id = in_id;
END;

create procedure sp_Inventories_Get()
BEGIN
    SELECT * FROM inventories WHERE is_deleted = false;
END;

create procedure sp_Inventories_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM inventories WHERE id = in_id;
END;

create procedure sp_Inventories_GetDeleted()
BEGIN
    SELECT * FROM inventories WHERE is_deleted = true;
END;

create procedure sp_Inventories_Search(IN in_name varchar(100), IN in_amount int)
BEGIN
    SELECT * FROM inventories
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (amount = in_amount OR in_amount IS NULL);
END;

create procedure sp_Inventories_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE inventories SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_Inventories_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_amount int)
BEGIN
    UPDATE inventories
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        amount = IF (in_amount IS NOT NULL, in_amount, amount)
    WHERE id = in_id;
END;

create procedure sp_LocationPerson_Add(IN in_location_id varchar(36), IN in_person_id varchar(36),
                                       OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO location_person (id, location_id, person_id, is_deleted)
    VALUES (out_id, in_location_id, in_person_id, false);
END;

create procedure sp_LocationPerson_Delete(IN in_id varchar(36))
BEGIN
    UPDATE location_person SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_LocationPerson_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM location_person WHERE id = in_id;
END;

create procedure sp_LocationPerson_Get()
BEGIN
    SELECT * FROM location_person WHERE is_deleted = false;
END;

create procedure sp_LocationPerson_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM location_person WHERE id = in_id;
end;

create procedure sp_LocationPerson_GetDeleted()
BEGIN
    SELECT * FROM location_person WHERE is_deleted = true;
END;

create procedure sp_LocationPerson_Search(IN in_location_id varchar(36), IN in_person_id varchar(36))
BEGIN
    SELECT * FROM location_person
    WHERE (location_id = in_location_id OR in_location_id IS NULL)
      AND (person_id = in_person_id OR in_person_id IS NULL);
END;

create procedure sp_LocationPerson_Update(IN in_id varchar(36), IN in_location_id varchar(36),
                                          IN in_person_id varchar(36))
BEGIN
    UPDATE location_person
    SET
        location_id = IF (in_location_id IS NOT NULL, in_location_id, location_id),
        person_id = IF (in_person_id IS NOT NULL, in_person_id, person_id)
    WHERE Id = in_id;
END;

create procedure sp_Locations_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO locations (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create procedure sp_Locations_Delete(IN in_id varchar(36))
BEGIN
    UPDATE locations SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Locations_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM locations WHERE id = in_id;
END;

create procedure sp_Locations_Get()
BEGIN
    SELECT * FROM locations WHERE is_deleted = false;
END;

create procedure sp_Locations_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM locations WHERE id = in_id;
end;

create procedure sp_Locations_GetDeleted()
BEGIN
    SELECT * FROM locations WHERE is_deleted = true;
END;

create procedure sp_Locations_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM locations
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create procedure sp_Locations_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE locations
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create procedure sp_PersonAdress_Add(IN in_personId varchar(36), IN in_adresseId varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_address (id, person_id, adresse_id, is_deleted)
    VALUES (out_id, in_personId, in_adresseId, false);
END;

create procedure sp_PersonAdress_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_address SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonAdress_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_address WHERE id = in_id;
END;

create procedure sp_PersonAdress_Get()
BEGIN
    SELECT * FROM person_address WHERE is_deleted = false;
END;

create procedure sp_PersonAdress_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_address WHERE id = in_id;
end;

create procedure sp_PersonAdress_Search(IN in_personId varchar(36), IN in_adressId varchar(36))
BEGIN
    SELECT * FROM person_address
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (adresse_id = in_adressId OR in_adressId IS NULL);
END;

create procedure sp_PersonAdress_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE person_address SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_PersonAdress_Update(IN in_id varchar(36), IN in_personId varchar(36), IN in_adressId varchar(36))
BEGIN
    UPDATE person_address
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        adresse_id = IF (in_adressId IS NOT NULL, in_adressId, adresse_id)
    WHERE Id = in_id;
end;

create procedure sp_PersonClass_Add(IN in_personId varchar(36), IN in_klasseId varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_klasse (id, person_id, klasse_id, is_deleted)
    VALUES (out_id, in_personId, in_klasseId, false);
END;

create procedure sp_PersonClass_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_klasse SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonClass_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_klasse WHERE id = in_id;
END;

create procedure sp_PersonClass_Get()
BEGIN
    SELECT * FROM person_klasse WHERE is_deleted = false;
END;

create procedure sp_PersonClass_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_klasse WHERE id = in_id;
end;

create procedure sp_PersonClass_GetDeleted()
BEGIN
    SELECT * FROM person_klasse WHERE is_deleted = true;
END;

create procedure sp_PersonClass_Search(IN in_personId varchar(36), IN in_klasseId varchar(36))
BEGIN
    SELECT * FROM person_klasse
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (klasse_id = in_klasseId OR in_klasseId IS NULL);
END;

create procedure sp_PersonClass_Update(IN in_id varchar(36), IN in_personId varchar(36), IN in_klasseId varchar(36))
BEGIN
    UPDATE person_klasse
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        klasse_id = IF (in_klasseId IS NOT NULL, in_klasseId, klasse_id)
    WHERE id = in_id;
END;

create procedure sp_PersonEmail_Add(IN in_personId varchar(36), IN in_email varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_email (id, person_id, email_id, is_deleted)
    VALUES (out_id, in_personId, in_email, false);
END;

create procedure sp_PersonEmail_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_email SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonEmail_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_email WHERE id = in_id;
END;

create procedure sp_PersonEmail_Get()
BEGIN
    SELECT * FROM person_email WHERE is_deleted = false;
END;

create procedure sp_PersonEmail_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_email WHERE id = in_id;
END;

create procedure sp_PersonEmail_Search(IN in_personId varchar(36), IN in_emailId varchar(36))
BEGIN
    SELECT * FROM person_email
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (email_id = in_emailId OR in_emailId IS NULL);
END;

create procedure sp_PersonEmail_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE person_email SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_PersonEmail_Update(IN in_id varchar(36), IN in_personId varchar(36), IN in_emailId varchar(36))
BEGIN
    UPDATE person_email
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        email_id = IF (in_emailId IS NOT NULL, in_emailId, email_id)
    WHERE id = in_id;
END;

create procedure sp_PersonPhone_Add(IN in_personId varchar(36), IN in_telefonnummerId varchar(36),
                                    OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_telefonnummer (id, person_id, telefonnummer_id, is_deleted)
    VALUES (out_id, in_personId, in_telefonnummerId, false);
END;

create procedure sp_PersonPhone_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_telefonnummer SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonPhone_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_telefonnummer WHERE id = in_id;
END;

create procedure sp_PersonPhone_Get()
BEGIN
    SELECT * FROM person_telefonnummer WHERE is_deleted = false;
END;

create procedure sp_PersonPhone_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_telefonnummer WHERE id = in_id;
end;

create procedure sp_PersonPhone_GetDeleted()
BEGIN
    SELECT * FROM person_telefonnummer WHERE is_deleted = true;
END;

create procedure sp_PersonPhone_Search(IN in_personId varchar(36), IN in_telefonnummerId varchar(36))
BEGIN
    SELECT * FROM person_telefonnummer
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (telefonnummer_id = in_telefonnummerId OR in_telefonnummerId IS NULL);
END;

create procedure sp_PersonPhone_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                       IN in_telefonnummerId varchar(36))
BEGIN
    UPDATE person_telefonnummer
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        telefonnummer_id = IF (in_telefonnummerId IS NOT NULL, in_telefonnummerId, telefonnummer_id)
    WHERE id = in_id;
END;

create procedure sp_PersonRole_Add(IN in_personId varchar(36), IN in_RolleId varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_role (id, person_id, rolle_id, is_deleted)
    VALUES (out_id, in_personId, in_RolleId, false);
END;

create procedure sp_PersonRole_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_role SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonRole_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_role WHERE id = in_id;
END;

create procedure sp_PersonRole_Get()
BEGIN
    SELECT * FROM person_role WHERE is_deleted = false;
END;

create procedure sp_PersonRole_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_role WHERE id = in_id;
end;

create procedure sp_PersonRole_GetDeleted()
BEGIN
    SELECT * FROM person_role WHERE is_deleted = true;
END;

create procedure sp_PersonRole_Search(IN in_personId varchar(36), IN in_RolleId varchar(36))
BEGIN
    SELECT * FROM person_role
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (rolle_id = in_RolleId OR in_RolleId IS NULL);
END;

create procedure sp_PersonRole_Update(IN in_id varchar(36), IN in_personId varchar(36), IN in_rolleId varchar(36))
BEGIN
    UPDATE person_role
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        rolle_id = IF (in_rolleId IS NOT NULL, in_rolleId, rolle_id)
    WHERE id = in_id;
END;

create procedure sp_Persons_Add(IN in_last_name varchar(100), IN in_first_name varchar(100), IN in_birthdate date,
                                OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person (id, last_name, first_name, birthdate, is_deleted)
    VALUES (out_id, in_last_name, in_first_name, in_birthdate, false);
END;

create procedure sp_Persons_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Persons_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person WHERE id = in_id;
END;

create procedure sp_Persons_Get()
BEGIN
    SELECT * FROM person WHERE is_deleted = false;
END;

create procedure sp_Persons_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person WHERE id = in_id;
end;

create procedure sp_Persons_GetDeleted()
BEGIN
    SELECT * FROM person WHERE is_deleted = true;
END;

create procedure sp_Persons_Search(IN in_last_name varchar(100), IN in_first_name varchar(100), IN in_birthdate date)
BEGIN
    SELECT * FROM person
    WHERE (last_name LIKE CONCAT('%', in_last_name, '%') OR in_last_name IS NULL)
      AND (first_name LIKE CONCAT('%', in_first_name, '%') OR in_first_name IS NULL)
      AND (birthdate = in_birthdate OR in_birthdate IS NULL);
END;

create procedure sp_Persons_Update(IN in_id varchar(36), IN in_last_name varchar(100), IN in_first_name varchar(100),
                                   IN in_birthdate date)
BEGIN
    UPDATE person
    SET
        last_name = IF (in_last_name IS NOT NULL, in_last_name, last_name),
        first_name = IF (in_first_name IS NOT NULL, in_first_name, first_name),
        birthdate = IF (in_birthdate IS NOT NULL, in_birthdate, birthdate)
    WHERE id = in_id;
END;

create procedure sp_Phones_Add(IN in_telefonnummer varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO telefonnummern (id, telefonnummer, is_deleted)
    VALUES (out_id, in_telefonnummer, false);
END;

create procedure sp_Phones_Delete(IN in_id varchar(36))
BEGIN
    UPDATE telefonnummern SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Phones_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM telefonnummern WHERE id = in_id;
END;

create procedure sp_Phones_Get()
BEGIN
    SELECT * FROM telefonnummern WHERE is_deleted = false;
END;

create procedure sp_Phones_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM telefonnummern WHERE id = in_id;
end;

create procedure sp_Phones_GetDeleted()
BEGIN
    SELECT * FROM telefonnummern WHERE is_deleted = true;
END;

create procedure sp_Phones_Search(IN in_telefonnummer varchar(100))
BEGIN
    SELECT * FROM telefonnummern
    WHERE (telefonnummer LIKE CONCAT('%', in_telefonnummer, '%') OR in_telefonnummer IS NULL);
END;

create procedure sp_Phones_Update(IN in_id varchar(36), IN in_telefonnummer varchar(100))
BEGIN
    UPDATE telefonnummern
    SET
        telefonnummer = IF (in_telefonnummer IS NOT NULL, in_telefonnummer, telefonnummer)
    WHERE id = in_id;
END;

create procedure sp_Roles_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO rollen (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create procedure sp_Roles_Delete(IN in_id varchar(36))
BEGIN
    UPDATE rollen SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Roles_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM rollen WHERE id = in_id;
END;

create procedure sp_Roles_Get()
BEGIN
    SELECT * FROM rollen WHERE is_deleted = false;
END;

create procedure sp_Roles_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM rollen WHERE id = in_id;
end;

create procedure sp_Roles_GetDeleted()
BEGIN
    SELECT * FROM rollen WHERE is_deleted = true;
END;

create procedure sp_Roles_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM rollen
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create procedure sp_Roles_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE rollen
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create procedure sp_Rooms_Add(IN in_name varchar(100), IN in_nr varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO raeume (id, name, nr, is_deleted)
    VALUES (out_id, in_name, in_nr, false);
END;

create procedure sp_Rooms_Delete(IN in_id varchar(36))
BEGIN
    UPDATE raeume SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Rooms_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM raeume WHERE id = in_id;
END;

create procedure sp_Rooms_Get()
BEGIN
    SELECT * FROM raeume WHERE is_deleted = false;
END;

create procedure sp_Rooms_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM raeume WHERE id = in_id;
end;

create procedure sp_Rooms_GetDeleted()
BEGIN
    SELECT * FROM raeume WHERE is_deleted = true;
END;

create procedure sp_Rooms_Search(IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    SELECT * FROM raeume
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (nr LIKE CONCAT('%', in_nr, '%') OR in_nr IS NULL);
END;

create procedure sp_Rooms_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    UPDATE raeume
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        nr = IF (in_nr IS NOT NULL, in_nr, nr)
    WHERE id = in_id;
END;

