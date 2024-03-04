create table if not exists address
(
    id           varchar(36)  not null,
    street       varchar(100) not null,
    house_number varchar(100) not null,
    postal_code  varchar(100) not null,
    location     varchar(100) not null,
    country      varchar(100) not null,
    is_deleted   tinyint(1)   not null
);

create table if not exists email
(
    id         varchar(36)  not null,
    email      varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists inventory
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    amount     int          not null,
    is_deleted tinyint(1)   not null
);

create table if not exists lesson
(
    id         varchar(36) not null,
    begin_date date        not null,
    end_date   date        not null,
    is_deleted tinyint(1)  not null
);

create table if not exists location
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists location_address
(
    id          varchar(36) not null,
    location_id varchar(36) not null,
    address_id  varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists location_email
(
    id          varchar(36) not null,
    location_id varchar(36) not null,
    email_id    varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists location_inventory
(
    id           varchar(36) not null,
    location_id  varchar(36) not null,
    inventory_id varchar(36) not null,
    is_deleted   tinyint(1)  not null
);

create table if not exists location_person
(
    id          varchar(36) not null,
    location_id varchar(36) not null,
    person_id   varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists location_phone
(
    id          varchar(36) not null,
    location_id varchar(36) not null,
    phone_id    varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists location_room
(
    id          varchar(36) not null,
    location_id varchar(36) not null,
    phone_id    varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table if not exists location_school_class
(
    id              varchar(36) not null,
    location_id     varchar(36) not null,
    school_class_id varchar(36) null,
    is_deleted      tinyint(1)  not null
);

create table if not exists module
(
    id          varchar(36)  not null,
    name        varchar(100) not null,
    description varchar(500) null,
    is_deleted  tinyint(1)   not null
);

create table if not exists module_person
(
    id         varchar(36) not null,
    module_id  varchar(36) not null,
    person_id  varchar(36) null,
    is_deleted tinyint(1)  not null
);

create table if not exists module_school_class
(
    id              varchar(36) not null,
    module_id       varchar(36) not null,
    school_class_id varchar(36) not null,
    is_deleted      tinyint(1)  not null
);

create table if not exists person
(
    id         varchar(36)  not null,
    last_name  varchar(100) not null,
    first_name varchar(100) not null,
    birthdate  date         not null,
    is_deleted tinyint(1)   not null
);

create table if not exists person_address
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    address_id varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_email
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    email_id   varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_phone
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    phone_id   varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_role
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    role_id    varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table if not exists person_school_class
(
    id              varchar(36) not null,
    person_id       varchar(36) not null,
    school_class_id varchar(36) not null,
    is_deleted      tinyint(1)  not null
);

create table if not exists phone
(
    id         varchar(36)  not null,
    phone      varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists role
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table if not exists room
(
    id         varchar(36)  not null,
    name       varchar(100) null,
    nr         varchar(100) null,
    is_deleted tinyint(1)   not null
);

create table if not exists school_class
(
    id         varchar(36)  not null,
    name       varchar(100) null,
    is_deleted tinyint(1)   not null
);

create procedure sp_Address_Add(IN in_street varchar(100), IN in_house_number varchar(100),
                                IN in_postal_code varchar(100), IN in_location varchar(100), IN in_country varchar(100),
                                OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO address (id, street, house_number, postal_code, location, country, is_deleted)
    VALUES (out_id, in_street, in_house_number, in_postal_code, in_location, in_country, false);
END;

create procedure sp_Address_Delete(IN in_id varchar(36))
BEGIN
    UPDATE address SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Address_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM address WHERE id = in_id;
END;

create procedure sp_Address_Get()
BEGIN
    SELECT * FROM address WHERE is_deleted = false;
END;

create procedure sp_Address_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM address WHERE id = in_id;
END;

create procedure sp_Address_GetDeleted()
BEGIN
    SELECT * FROM address WHERE is_deleted = true;
END;

create procedure sp_Address_Search(IN in_street varchar(100), IN in_house_number varchar(100),
                                   IN in_postal_code varchar(100), IN in_location varchar(100),
                                   IN in_country varchar(100))
BEGIN
    SELECT * FROM address
    WHERE (street LIKE CONCAT('%', in_street, '%') OR in_street IS NULL)
      AND (house_number LIKE CONCAT('%', in_house_number, '%') OR in_house_number IS NULL)
      AND (postal_code LIKE CONCAT('%', in_postal_code, '%') OR in_postal_code IS NULL)
      AND (location LIKE CONCAT('%', in_location, '%') OR in_location IS NULL)
      AND (country LIKE CONCAT('%', in_country, '%') OR in_country IS NULL);
END;

create procedure sp_Adress_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE address
    SET
        is_deleted = false
    WHERE id = in_id;
END;

create procedure sp_Adress_Update(IN in_id varchar(36), IN in_street varchar(100), IN in_house_number varchar(100),
                                  IN in_postal_code varchar(100), IN in_location varchar(100),
                                  IN in_country varchar(100))
BEGIN
    UPDATE address
    SET
        street = IF (in_street IS NOT NULL, in_street, street),
        house_number = IF (in_house_number IS NOT NULL, in_house_number, house_number),
        postal_code = IF (in_postal_code IS NOT NULL, in_postal_code, postal_code),
        location = IF (in_location IS NOT NULL, in_location, location),
        country = IF (in_country IS NOT NULL, in_country, country)
    WHERE id = in_id;
END;

create procedure sp_Email_Add(IN in_email varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO email (id, email, is_deleted)
    VALUES (out_id, in_email, false);
END;

create procedure sp_Email_Delete(IN in_id varchar(36))
BEGIN
    UPDATE email SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Email_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM email WHERE id = in_id;
END;

create procedure sp_Email_Get()
BEGIN
    SELECT * FROM email WHERE is_deleted = false;
END;

create procedure sp_Email_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM email WHERE id = in_id;
END;

create procedure sp_Email_GetDeleted()
BEGIN
    SELECT * FROM email WHERE is_deleted = true;
END;

create procedure sp_Email_Search(IN in_email varchar(100))
BEGIN
    SELECT * FROM email
    WHERE (email LIKE CONCAT('%', in_email, '%') OR in_email IS NULL);
END;

create procedure sp_Email_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE email SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_Email_Update(IN in_id varchar(36), IN in_email varchar(100))
BEGIN
    UPDATE email
    SET
        email = IF (in_email IS NOT NULL, in_email, email)
    WHERE id = in_id;
END;

create procedure sp_Inventory_Add(IN in_name varchar(100), IN in_amount varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO inventory (id, name, amount, is_deleted)
    VALUES (out_id, in_name, in_amount, false);
END;

create procedure sp_Inventory_Delete(IN in_id varchar(36))
BEGIN
    UPDATE inventory SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Inventory_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM inventory WHERE id = in_id;
END;

create procedure sp_Inventory_Get()
BEGIN
    SELECT * FROM inventory WHERE is_deleted = false;
END;

create procedure sp_Inventory_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM inventory WHERE id = in_id;
END;

create procedure sp_Inventory_GetDeleted()
BEGIN
    SELECT * FROM inventory WHERE is_deleted = true;
END;

create procedure sp_Inventory_Search(IN in_name varchar(100), IN in_amount int)
BEGIN
    SELECT * FROM inventory
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (amount = in_amount OR in_amount IS NULL);
END;

create procedure sp_Inventory_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE inventory SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_Inventory_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_amount int)
BEGIN
    UPDATE inventory
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

create procedure sp_Location_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO location (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create procedure sp_Location_Delete(IN in_id varchar(36))
BEGIN
    UPDATE location SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Location_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM location WHERE id = in_id;
END;

create procedure sp_Location_Get()
BEGIN
    SELECT * FROM location WHERE is_deleted = false;
END;

create procedure sp_Location_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM location WHERE id = in_id;
end;

create procedure sp_Location_GetDeleted()
BEGIN
    SELECT * FROM location WHERE is_deleted = true;
END;

create procedure sp_Location_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM location
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create procedure sp_Location_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE location
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create procedure sp_Module_Add(IN in_name varchar(100), IN in_description varchar(250), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO module (id, name, description, is_deleted)
    VALUES (out_id, in_name, in_description, false);
END;

create procedure sp_Module_Delete(IN in_id varchar(36))
BEGIN
    UPDATE module
    SET is_deleted = true
    WHERE id = in_id;
END;

create procedure sp_Module_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM module WHERE id = in_id;
END;

create procedure sp_Module_Get()
BEGIN
    SELECT * FROM module WHERE is_deleted = false;
END;

create procedure sp_Module_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM module WHERE id = in_id;
END;

create procedure sp_Module_GetDeleted()
BEGIN
    SELECT * FROM module WHERE is_deleted = true;
END;

create procedure sp_Module_Search(IN in_name varchar(100), IN in_description varchar(250))
BEGIN
    SELECT * FROM module
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (description LIKE CONCAT('%', in_description, '%') OR in_description IS NULL);
END;

create procedure sp_Module_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE module
    SET is_deleted = false
    WHERE id = in_id;
END;

create procedure sp_Module_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_description varchar(250))
BEGIN
    UPDATE module
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        description = IF (in_description IS NOT NULL, in_description, description)
    WHERE id = in_id;
END;

create procedure sp_PersonAddress_Add(IN in_person_id varchar(36), IN in_address_id varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_address (id, person_id, address_id, is_deleted)
    VALUES (out_id, in_person_id, in_address_id, false);
END;

create procedure sp_PersonAddress_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_address SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonAddress_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_address WHERE id = in_id;
END;

create procedure sp_PersonAddress_Get()
BEGIN
    SELECT * FROM person_address WHERE is_deleted = false;
END;

create procedure sp_PersonAddress_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_address WHERE id = in_id;
end;

create procedure sp_PersonAddress_Search(IN in_person_id varchar(36), IN in_address_id varchar(36))
BEGIN
    SELECT * FROM person_address
    WHERE (person_id = in_person_id OR in_person_id IS NULL)
      AND (address_id = in_address_id OR in_address_id IS NULL);
END;

create procedure sp_PersonAddress_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE person_address SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_PersonAddress_Update(IN in_id varchar(36), IN in_person_id varchar(36),
                                         IN in_address_id varchar(36))
BEGIN
    UPDATE person_address
    SET
        person_id = IF (in_person_id IS NOT NULL, in_person_id, person_id),
        address_id = IF (in_address_id IS NOT NULL, in_address_id, address_id)
    WHERE Id = in_id;
end;

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

create procedure sp_PersonPhone_Add(IN in_personId varchar(36), IN in_phone_id varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_phone (id, person_id, phone_id, is_deleted)
    VALUES (out_id, in_personId, in_phone_id, false);
END;

create procedure sp_PersonPhone_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_phone SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonPhone_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_phone WHERE id = in_id;
END;

create procedure sp_PersonPhone_Get()
BEGIN
    SELECT * FROM person_phone WHERE is_deleted = false;
END;

create procedure sp_PersonPhone_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_phone WHERE id = in_id;
end;

create procedure sp_PersonPhone_GetDeleted()
BEGIN
    SELECT * FROM person_phone WHERE is_deleted = true;
END;

create procedure sp_PersonPhone_Search(IN in_personId varchar(36), IN in_phone_id varchar(36))
BEGIN
    SELECT * FROM person_phone
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (phone_id = in_phone_id OR in_phone_id IS NULL);
END;

create procedure sp_PersonPhone_Update(IN in_id varchar(36), IN in_personId varchar(36), IN in_phone_id varchar(36))
BEGIN
    UPDATE person_phone
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        phone_id = IF (in_phone_id IS NOT NULL, in_phone_id, phone_id)
    WHERE id = in_id;
END;

create procedure sp_PersonRole_Add(IN in_personId varchar(36), IN in_role_id varchar(36), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_role (id, person_id, role_id, is_deleted)
    VALUES (out_id, in_personId, in_role_id, false);
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

create procedure sp_PersonRole_Search(IN in_personId varchar(36), IN in_role_id varchar(36))
BEGIN
    SELECT * FROM person_role
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (role_id = in_role_id OR in_role_id IS NULL);
END;

create procedure sp_PersonRole_Update(IN in_id varchar(36), IN in_personId varchar(36), IN in_role_id varchar(36))
BEGIN
    UPDATE person_role
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        role_id = IF (in_role_id IS NOT NULL, in_role_id, role_id)
    WHERE id = in_id;
END;

create procedure sp_PersonSchoolClass_Add(IN in_personId varchar(36), IN in_school_class_id varchar(36),
                                          OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_school_class (id, person_id, school_class_id, is_deleted)
    VALUES (out_id, in_personId, in_school_class_id, false);
END;

create procedure sp_PersonSchoolClass_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_school_class SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_PersonSchoolClass_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_school_class WHERE id = in_id;
END;

create procedure sp_PersonSchoolClass_Get()
BEGIN
    SELECT * FROM person_school_class WHERE is_deleted = false;
END;

create procedure sp_PersonSchoolClass_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_school_class WHERE id = in_id;
end;

create procedure sp_PersonSchoolClass_GetDeleted()
BEGIN
    SELECT * FROM person_school_class WHERE is_deleted = true;
END;

create procedure sp_PersonSchoolClass_Search(IN in_personId varchar(36), IN in_school_class_id varchar(36))
BEGIN
    SELECT * FROM person_school_class
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (school_class_id = in_school_class_id OR in_school_class_id IS NULL);
END;

create procedure sp_PersonSchoolClass_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                             IN in_school_class_id varchar(36))
BEGIN
    UPDATE person_school_class
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        school_class_id = IF (in_school_class_id IS NOT NULL, in_school_class_id, school_class_id)
    WHERE id = in_id;
END;

create procedure sp_Person_Add(IN in_last_name varchar(100), IN in_first_name varchar(100), IN in_birthdate date,
                               OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person (id, last_name, first_name, birthdate, is_deleted)
    VALUES (out_id, in_last_name, in_first_name, in_birthdate, false);
END;

create procedure sp_Person_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Person_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person WHERE id = in_id;
END;

create procedure sp_Person_Get()
BEGIN
    SELECT * FROM person WHERE is_deleted = false;
END;

create procedure sp_Person_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person WHERE id = in_id;
end;

create procedure sp_Person_GetDeleted()
BEGIN
    SELECT * FROM person WHERE is_deleted = true;
END;

create procedure sp_Person_Search(IN in_last_name varchar(100), IN in_first_name varchar(100), IN in_birthdate date)
BEGIN
    SELECT * FROM person
    WHERE (last_name LIKE CONCAT('%', in_last_name, '%') OR in_last_name IS NULL)
      AND (first_name LIKE CONCAT('%', in_first_name, '%') OR in_first_name IS NULL)
      AND (birthdate = in_birthdate OR in_birthdate IS NULL);
END;

create procedure sp_Person_Update(IN in_id varchar(36), IN in_last_name varchar(100), IN in_first_name varchar(100),
                                  IN in_birthdate date)
BEGIN
    UPDATE person
    SET
        last_name = IF (in_last_name IS NOT NULL, in_last_name, last_name),
        first_name = IF (in_first_name IS NOT NULL, in_first_name, first_name),
        birthdate = IF (in_birthdate IS NOT NULL, in_birthdate, birthdate)
    WHERE id = in_id;
END;

create procedure sp_Phone_Add(IN in_phone varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO phone (id, phone, is_deleted)
    VALUES (out_id, in_phone, false);
END;

create procedure sp_Phone_Delete(IN in_id varchar(36))
BEGIN
    UPDATE phone SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Phone_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM phone WHERE id = in_id;
END;

create procedure sp_Phone_Get()
BEGIN
    SELECT * FROM phone WHERE is_deleted = false;
END;

create procedure sp_Phone_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM phone WHERE id = in_id;
end;

create procedure sp_Phone_GetDeleted()
BEGIN
    SELECT * FROM phone WHERE is_deleted = true;
END;

create procedure sp_Phone_Search(IN in_phone varchar(100))
BEGIN
    SELECT * FROM phone
    WHERE (phone LIKE CONCAT('%', in_phone, '%') OR in_phone IS NULL);
END;

create procedure sp_Phone_Update(IN in_id varchar(36), IN in_phone varchar(100))
BEGIN
    UPDATE phone
    SET
        phone = IF (in_phone IS NOT NULL, in_phone, phone)
    WHERE id = in_id;
END;

create procedure sp_Role_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO role (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create procedure sp_Role_Delete(IN in_id varchar(36))
BEGIN
    UPDATE role SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Role_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM role WHERE id = in_id;
END;

create procedure sp_Role_Get()
BEGIN
    SELECT * FROM role WHERE is_deleted = false;
END;

create procedure sp_Role_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM role WHERE id = in_id;
end;

create procedure sp_Role_GetDeleted()
BEGIN
    SELECT * FROM role WHERE is_deleted = true;
END;

create procedure sp_Role_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM role
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create procedure sp_Role_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE role
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create procedure sp_Room_Add(IN in_name varchar(100), IN in_nr varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO room (id, name, nr, is_deleted)
    VALUES (out_id, in_name, in_nr, false);
END;

create procedure sp_Room_Delete(IN in_id varchar(36))
BEGIN
    UPDATE room SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_Room_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM room WHERE id = in_id;
END;

create procedure sp_Room_Get()
BEGIN
    SELECT * FROM room WHERE is_deleted = false;
END;

create procedure sp_Room_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM room WHERE id = in_id;
end;

create procedure sp_Room_GetDeleted()
BEGIN
    SELECT * FROM room WHERE is_deleted = true;
END;

create procedure sp_Room_Search(IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    SELECT * FROM room
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (nr LIKE CONCAT('%', in_nr, '%') OR in_nr IS NULL);
END;

create procedure sp_Room_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    UPDATE room
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        nr = IF (in_nr IS NOT NULL, in_nr, nr)
    WHERE id = in_id;
END;

create procedure sp_SchoolClass_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO school_class (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create procedure sp_SchoolClass_Delete(IN in_id varchar(36))
BEGIN
    UPDATE school_class SET is_deleted = true WHERE id = in_id;
END;

create procedure sp_SchoolClass_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM school_class WHERE id = in_id;
END;

create procedure sp_SchoolClass_Get()
BEGIN
    SELECT * FROM school_class WHERE is_deleted = false;
END;

create procedure sp_SchoolClass_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM school_class WHERE id = in_id;
END;

create procedure sp_SchoolClass_GetDeleted()
BEGIN
    SELECT * FROM school_class WHERE is_deleted = true;
END;

create procedure sp_SchoolClass_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM school_class
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create procedure sp_SchoolClass_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE school_class SET is_deleted = false WHERE id = in_id;
END;

create procedure sp_SchoolClass_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE school_class
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

