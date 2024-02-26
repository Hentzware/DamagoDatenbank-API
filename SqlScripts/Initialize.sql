create table adressen
(
    id           varchar(36)  not null,
    strasse      varchar(100) not null,
    hausnummer   varchar(100) not null,
    postleitzahl varchar(100) not null,
    ort          varchar(100) not null,
    land         varchar(100) not null,
    is_deleted   tinyint(1)   not null
);

create table emails
(
    id         varchar(36)  not null,
    email      varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table inventar
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    anzahl     int          null,
    is_deleted tinyint(1)   not null
);

create table klassen
(
    id         varchar(36)  not null,
    name       varchar(100) null,
    is_deleted tinyint(1)   not null
);

create table modul_klasse
(
    id         varchar(36) not null,
    modul_id   varchar(36) not null,
    klasse_id  varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table modul_person
(
    id         varchar(36) not null,
    modul_id   varchar(36) not null,
    person_id  varchar(36) null,
    is_deleted tinyint(1)  not null
);

create table module
(
    id           varchar(36)  not null,
    name         varchar(100) not null,
    beschreibung varchar(500) null,
    is_deleted   tinyint(1)   not null
);

create table person_adresse
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    adresse_id varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table person_email
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    email_id   varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table person_klasse
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    klasse_id  varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table person_rolle
(
    id         varchar(36) not null,
    person_id  varchar(36) not null,
    rolle_id   varchar(36) not null,
    is_deleted tinyint(1)  not null
);

create table person_telefonnummer
(
    id               varchar(36) not null,
    person_id        varchar(36) not null,
    telefonnummer_id varchar(36) not null,
    is_deleted       tinyint(1)  not null
);

create table personen
(
    id           varchar(36)  not null,
    vorname      varchar(100) not null,
    nachname     varchar(100) not null,
    geburtsdatum date         not null,
    is_deleted   tinyint(1)   not null
);

create table raeume
(
    id         varchar(36)  not null,
    name       varchar(100) null,
    nr         varchar(100) null,
    is_deleted tinyint(1)   not null
);

create table rollen
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table standort_adresse
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    adresse_id  varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table standort_email
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    email_id    varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table standort_inventar
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    inventar_id varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table standort_klasse
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    klasse_id   varchar(36) null,
    is_deleted  tinyint(1)  not null
);

create table standort_person
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    person_id   varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table standort_raum
(
    id          varchar(36) not null,
    standort_id varchar(36) not null,
    raum_id     varchar(36) not null,
    is_deleted  tinyint(1)  not null
);

create table standort_telefonnummer
(
    id               varchar(36) not null,
    standort_id      varchar(36) not null,
    telefonnummer_id varchar(36) not null,
    is_deleted       tinyint(1)  not null
);

create table standorte
(
    id         varchar(36)  not null,
    name       varchar(100) not null,
    is_deleted tinyint(1)   not null
);

create table telefonnummern
(
    id            varchar(36)  not null,
    telefonnummer varchar(100) not null,
    is_deleted    tinyint(1)   not null
);

create table unterricht
(
    id           varchar(36) not null,
    beginn_datum date        not null,
    ende_datum   date        not null,
    is_deleted   tinyint(1)  not null
);

create
    definer = root@`%` procedure sp_Adresses_Add(IN in_strasse varchar(100), IN in_hausnummer varchar(100),
                                                 IN in_postleitzahl varchar(100), IN in_ort varchar(100),
                                                 IN in_land varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO adressen (id, strasse, hausnummer, postleitzahl, ort, land, is_deleted)
    VALUES (out_id, in_strasse, in_hausnummer, in_postleitzahl, in_ort, in_land, false);
END;

create
    definer = root@`%` procedure sp_Adresses_Delete(IN in_id varchar(36))
BEGIN
    UPDATE adressen SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Adresses_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM adressen WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Adresses_Get()
BEGIN
    SELECT * FROM adressen WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Adresses_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM adressen WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Adresses_GetDeleted()
BEGIN
    SELECT * FROM adressen WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Adresses_Search(IN in_strasse varchar(100), IN in_hausnummer varchar(100),
                                                    IN in_postleitzahl varchar(100), IN in_ort varchar(100),
                                                    IN in_land varchar(100))
BEGIN
    SELECT * FROM adressen
    WHERE (strasse LIKE CONCAT('%', in_strasse, '%') OR in_strasse IS NULL)
      AND (hausnummer LIKE CONCAT('%', in_hausnummer, '%') OR in_hausnummer IS NULL)
      AND (postleitzahl LIKE CONCAT('%', in_postleitzahl, '%') OR in_postleitzahl IS NULL)
      AND (ort LIKE CONCAT('%', in_ort, '%') OR in_ort IS NULL)
      AND (land LIKE CONCAT('%', in_land, '%') OR in_land IS NULL);
END;

create
    definer = root@`%` procedure sp_Adresses_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE adressen
    SET
        is_deleted = false
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Adresses_Update(IN in_id varchar(36), IN in_strasse varchar(100),
                                                    IN in_hausnummer varchar(100), IN in_postleitzahl varchar(100),
                                                    IN in_ort varchar(100), IN in_land varchar(100))
BEGIN
    UPDATE adressen
    SET
        strasse = IF (in_strasse IS NOT NULL, in_strasse, strasse),
        hausnummer = IF (in_hausnummer IS NOT NULL, in_hausnummer, hausnummer),
        postleitzahl = IF (in_postleitzahl IS NOT NULL, in_postleitzahl, postleitzahl),
        ort = IF (in_ort IS NOT NULL, in_ort, ort),
        land = IF (in_land IS NOT NULL, in_land, land)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Classes_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO klassen (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create
    definer = root@`%` procedure sp_Classes_Delete(IN in_id varchar(36))
BEGIN
    UPDATE klassen SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Classes_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM klassen WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Classes_Get()
BEGIN
    SELECT * FROM klassen WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Classes_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM klassen WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Classes_GetDeleted()
BEGIN
    SELECT * FROM klassen WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Classes_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM klassen
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create
    definer = root@`%` procedure sp_Classes_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE klassen SET is_deleted = false WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Classes_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE klassen
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Emails_Add(IN in_email varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO emails (id, email, is_deleted)
    VALUES (out_id, in_email, false);
END;

create
    definer = root@`%` procedure sp_Emails_Delete(IN in_id varchar(36))
BEGIN
    UPDATE emails SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Emails_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM emails WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Emails_Get()
BEGIN
    SELECT * FROM emails WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Emails_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM emails WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Emails_GetDeleted()
BEGIN
    SELECT * FROM emails WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Emails_Search(IN in_email varchar(100))
BEGIN
    SELECT * FROM emails
    WHERE (email LIKE CONCAT('%', in_email, '%') OR in_email IS NULL);
END;

create
    definer = root@`%` procedure sp_Emails_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE emails SET is_deleted = false WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Emails_Update(IN in_id varchar(36), IN in_email varchar(100))
BEGIN
    UPDATE emails
    SET
        email = IF (in_email IS NOT NULL, in_email, email)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Inventory_Add(IN in_name varchar(100), IN in_anzahl varchar(100),
                                                  OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO inventar (id, name, anzahl, is_deleted)
    VALUES (out_id, in_name, in_anzahl, false);
END;

create
    definer = root@`%` procedure sp_Inventory_Delete(IN in_id varchar(36))
BEGIN
    UPDATE inventar SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Inventory_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM inventar WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Inventory_Get()
BEGIN
    SELECT * FROM inventar WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Inventory_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM inventar WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Inventory_GetDeleted()
BEGIN
    SELECT * FROM inventar WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Inventory_Search(IN in_name varchar(100), IN in_anzahl int)
BEGIN
    SELECT * FROM inventar
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (anzahl = in_anzahl OR in_anzahl IS NULL);
END;

create
    definer = root@`%` procedure sp_Inventory_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE inventar SET is_deleted = false WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Inventory_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_anzahl int)
BEGIN
    UPDATE inventar
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        anzahl = IF (in_anzahl IS NOT NULL, in_anzahl, anzahl)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_LocationPerson_Add(IN in_personId varchar(36), IN in_StandortId varchar(36),
                                                       OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO standort_person (id, person_id, standort_id, is_deleted)
    VALUES (out_id, in_personId, in_StandortId, false);
END;

create
    definer = root@`%` procedure sp_LocationPerson_Delete(IN in_id varchar(36))
BEGIN
    UPDATE standort_person SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_LocationPerson_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM standort_person WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_LocationPerson_Get()
BEGIN
    SELECT * FROM standort_person WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_LocationPerson_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM standort_person WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_LocationPerson_GetDeleted()
BEGIN
    SELECT * FROM standort_person WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_LocationPerson_Search(IN in_personId varchar(36), IN in_StandortId varchar(36))
BEGIN
    SELECT * FROM standort_person
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (standort_id = in_StandortId OR in_StandortId IS NULL);
END;

create
    definer = root@`%` procedure sp_LocationPerson_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                                          IN in_StandortId varchar(36))
BEGIN
    UPDATE standort_person
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        standort_id = IF (in_StandortId IS NOT NULL, in_StandortId, standort_id)
    WHERE Id = in_id;
END;

create
    definer = root@`%` procedure sp_Locations_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO standorte (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create
    definer = root@`%` procedure sp_Locations_Delete(IN in_id varchar(36))
BEGIN
    UPDATE standorte SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Locations_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM standorte WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Locations_Get()
BEGIN
    SELECT * FROM standorte WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Locations_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM standorte WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_Locations_GetDeleted()
BEGIN
    SELECT * FROM standorte WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Locations_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM standorte
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create
    definer = root@`%` procedure sp_Locations_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE standorte
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Modules_Add(IN in_name varchar(100), IN in_beschreibung varchar(100),
                                                OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO module (id, name,beschreibung, is_deleted)
    VALUES (out_id, in_name,in_beschreibung, false);
END;

create
    definer = root@`%` procedure sp_Modules_Delete(IN in_id varchar(36))
BEGIN
    UPDATE module SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Modules_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM module WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Modules_Get()
BEGIN
    SELECT * FROM module WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Modules_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM module WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Modules_GetDeleted()
BEGIN
    SELECT * FROM module WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Modules_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM module
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create
    definer = root@`%` procedure sp_Modules_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE module SET is_deleted = false WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Modules_Update(IN in_id varchar(36), IN in_name varchar(100),
                                                   IN in_beschreibung varchar(100))
BEGIN
    UPDATE module
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        beschreibung = IF (in_beschreibung IS NOT NULL, in_beschreibung, beschreibung)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonAdress_Add(IN in_personId varchar(36), IN in_adresseId varchar(36),
                                                     OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_adresse (id, person_id, adresse_id, is_deleted)
    VALUES (out_id, in_personId, in_adresseId, false);
END;

create
    definer = root@`%` procedure sp_PersonAdress_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_adresse SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonAdress_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_adresse WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonAdress_Get()
BEGIN
    SELECT * FROM person_adresse WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_PersonAdress_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_adresse WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_PersonAdress_Search(IN in_personId varchar(36), IN in_adressId varchar(36))
BEGIN
    SELECT * FROM person_adresse
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (adresse_id = in_adressId OR in_adressId IS NULL);
END;

create
    definer = root@`%` procedure sp_PersonAdress_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE person_adresse SET is_deleted = false WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonAdress_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                                        IN in_adressId varchar(36))
BEGIN
    UPDATE person_adresse
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        adresse_id = IF (in_adressId IS NOT NULL, in_adressId, adresse_id)
    WHERE Id = in_id;
end;

create
    definer = root@`%` procedure sp_PersonClass_Add(IN in_personId varchar(36), IN in_klasseId varchar(36),
                                                    OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_klasse (id, person_id, klasse_id, is_deleted)
    VALUES (out_id, in_personId, in_klasseId, false);
END;

create
    definer = root@`%` procedure sp_PersonClass_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_klasse SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonClass_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_klasse WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonClass_Get()
BEGIN
    SELECT * FROM person_klasse WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_PersonClass_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_klasse WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_PersonClass_GetDeleted()
BEGIN
    SELECT * FROM person_klasse WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_PersonClass_Search(IN in_personId varchar(36), IN in_klasseId varchar(36))
BEGIN
    SELECT * FROM person_klasse
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (klasse_id = in_klasseId OR in_klasseId IS NULL);
END;

create
    definer = root@`%` procedure sp_PersonClass_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                                       IN in_klasseId varchar(36))
BEGIN
    UPDATE person_klasse
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        klasse_id = IF (in_klasseId IS NOT NULL, in_klasseId, klasse_id)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonEmail_Add(IN in_personId varchar(36), IN in_email varchar(36),
                                                    OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_email (id, person_id, email_id, is_deleted)
    VALUES (out_id, in_personId, in_email, false);
END;

create
    definer = root@`%` procedure sp_PersonEmail_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_email SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonEmail_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_email WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonEmail_Get()
BEGIN
    SELECT * FROM person_email WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_PersonEmail_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_email WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonEmail_Search(IN in_personId varchar(36), IN in_emailId varchar(36))
BEGIN
    SELECT * FROM person_email
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (email_id = in_emailId OR in_emailId IS NULL);
END;

create
    definer = root@`%` procedure sp_PersonEmail_Undelete(IN in_id varchar(36))
BEGIN
    UPDATE person_email SET is_deleted = false WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonEmail_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                                       IN in_emailId varchar(36))
BEGIN
    UPDATE person_email
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        email_id = IF (in_emailId IS NOT NULL, in_emailId, email_id)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonPhone_Add(IN in_personId varchar(36), IN in_telefonnummerId varchar(36),
                                                    OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_telefonnummer (id, person_id, telefonnummer_id, is_deleted)
    VALUES (out_id, in_personId, in_telefonnummerId, false);
END;

create
    definer = root@`%` procedure sp_PersonPhone_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_telefonnummer SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonPhone_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_telefonnummer WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonPhone_Get()
BEGIN
    SELECT * FROM person_telefonnummer WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_PersonPhone_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_telefonnummer WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_PersonPhone_GetDeleted()
BEGIN
    SELECT * FROM person_telefonnummer WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_PersonPhone_Search(IN in_personId varchar(36), IN in_telefonnummerId varchar(36))
BEGIN
    SELECT * FROM person_telefonnummer
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (telefonnummer_id = in_telefonnummerId OR in_telefonnummerId IS NULL);
END;

create
    definer = root@`%` procedure sp_PersonPhone_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                                       IN in_telefonnummerId varchar(36))
BEGIN
    UPDATE person_telefonnummer
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        telefonnummer_id = IF (in_telefonnummerId IS NOT NULL, in_telefonnummerId, telefonnummer_id)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonRole_Add(IN in_personId varchar(36), IN in_RolleId varchar(36),
                                                   OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO person_rolle (id, person_id, rolle_id, is_deleted)
    VALUES (out_id, in_personId, in_RolleId, false);
END;

create
    definer = root@`%` procedure sp_PersonRole_Delete(IN in_id varchar(36))
BEGIN
    UPDATE person_rolle SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonRole_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM person_rolle WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_PersonRole_Get()
BEGIN
    SELECT * FROM person_rolle WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_PersonRole_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM person_rolle WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_PersonRole_GetDeleted()
BEGIN
    SELECT * FROM person_rolle WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_PersonRole_Search(IN in_personId varchar(36), IN in_RolleId varchar(36))
BEGIN
    SELECT * FROM person_rolle
    WHERE (person_id = in_personId OR in_personId IS NULL)
      AND (rolle_id = in_RolleId OR in_RolleId IS NULL);
END;

create
    definer = root@`%` procedure sp_PersonRole_Update(IN in_id varchar(36), IN in_personId varchar(36),
                                                      IN in_rolleId varchar(36))
BEGIN
    UPDATE person_rolle
    SET
        person_id = IF (in_personId IS NOT NULL, in_personId, person_id),
        rolle_id = IF (in_rolleId IS NOT NULL, in_rolleId, rolle_id)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Persons_Add(IN in_nachname varchar(100), IN in_vorname varchar(100),
                                                IN in_geburtsdatum date, OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO personen (id, nachname, vorname, geburtsdatum, is_deleted)
    VALUES (out_id, in_nachname, in_vorname, in_geburtsdatum, false);
END;

create
    definer = root@`%` procedure sp_Persons_Delete(IN in_id varchar(36))
BEGIN
    UPDATE personen SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Persons_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM personen WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Persons_Get()
BEGIN
    SELECT * FROM personen WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Persons_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM personen WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_Persons_GetDeleted()
BEGIN
    SELECT * FROM personen WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Persons_Search(IN in_nachname varchar(100), IN in_vorname varchar(100),
                                                   IN in_geburtsdatum date)
BEGIN
    SELECT * FROM personen
    WHERE (nachname LIKE CONCAT('%', in_nachname, '%') OR in_nachname IS NULL)
      AND (vorname LIKE CONCAT('%', in_vorname, '%') OR in_vorname IS NULL)
      AND (geburtsdatum = in_geburtsdatum OR in_geburtsdatum IS NULL);
END;

create
    definer = root@`%` procedure sp_Persons_Update(IN in_id varchar(36), IN in_nachname varchar(100),
                                                   IN in_vorname varchar(100), IN in_geburtsdatum date)
BEGIN
    UPDATE personen
    SET
        nachname = IF (in_nachname IS NOT NULL, in_nachname, nachname),
        vorname = IF (in_vorname IS NOT NULL, in_vorname, vorname),
        geburtsdatum = IF (in_geburtsdatum IS NOT NULL, in_geburtsdatum, geburtsdatum)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Phones_Add(IN in_telefonnummer varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO telefonnummern (id, telefonnummer, is_deleted)
    VALUES (out_id, in_telefonnummer, false);
END;

create
    definer = root@`%` procedure sp_Phones_Delete(IN in_id varchar(36))
BEGIN
    UPDATE telefonnummern SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Phones_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM telefonnummern WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Phones_Get()
BEGIN
    SELECT * FROM telefonnummern WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Phones_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM telefonnummern WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_Phones_GetDeleted()
BEGIN
    SELECT * FROM telefonnummern WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Phones_Search(IN in_telefonnummer varchar(100))
BEGIN
    SELECT * FROM telefonnummern
    WHERE (telefonnummer LIKE CONCAT('%', in_telefonnummer, '%') OR in_telefonnummer IS NULL);
END;

create
    definer = root@`%` procedure sp_Phones_Update(IN in_id varchar(36), IN in_telefonnummer varchar(100))
BEGIN
    UPDATE telefonnummern
    SET
        telefonnummer = IF (in_telefonnummer IS NOT NULL, in_telefonnummer, telefonnummer)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Roles_Add(IN in_name varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO rollen (id, name, is_deleted)
    VALUES (out_id, in_name, false);
END;

create
    definer = root@`%` procedure sp_Roles_Delete(IN in_id varchar(36))
BEGIN
    UPDATE rollen SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Roles_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM rollen WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Roles_Get()
BEGIN
    SELECT * FROM rollen WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Roles_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM rollen WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_Roles_GetDeleted()
BEGIN
    SELECT * FROM rollen WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Roles_Search(IN in_name varchar(100))
BEGIN
    SELECT * FROM rollen
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL);
END;

create
    definer = root@`%` procedure sp_Roles_Update(IN in_id varchar(36), IN in_name varchar(100))
BEGIN
    UPDATE rollen
    SET
        name = IF (in_name IS NOT NULL, in_name, name)
    WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Rooms_Add(IN in_name varchar(100), IN in_nr varchar(100), OUT out_id varchar(36))
BEGIN
    SET out_id = UUID();
    INSERT INTO raeume (id, name, nr, is_deleted)
    VALUES (out_id, in_name, in_nr, false);
END;

create
    definer = root@`%` procedure sp_Rooms_Delete(IN in_id varchar(36))
BEGIN
    UPDATE raeume SET is_deleted = true WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Rooms_DeletePermanent(IN in_id varchar(36))
BEGIN
    DELETE FROM raeume WHERE id = in_id;
END;

create
    definer = root@`%` procedure sp_Rooms_Get()
BEGIN
    SELECT * FROM raeume WHERE is_deleted = false;
END;

create
    definer = root@`%` procedure sp_Rooms_GetById(IN in_id varchar(36))
BEGIN
    SELECT * FROM raeume WHERE id = in_id;
end;

create
    definer = root@`%` procedure sp_Rooms_GetDeleted()
BEGIN
    SELECT * FROM raeume WHERE is_deleted = true;
END;

create
    definer = root@`%` procedure sp_Rooms_Search(IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    SELECT * FROM raeume
    WHERE (name LIKE CONCAT('%', in_name, '%') OR in_name IS NULL)
      AND (nr LIKE CONCAT('%', in_nr, '%') OR in_nr IS NULL);
END;

create
    definer = root@`%` procedure sp_Rooms_Update(IN in_id varchar(36), IN in_name varchar(100), IN in_nr varchar(100))
BEGIN
    UPDATE raeume
    SET
        name = IF (in_name IS NOT NULL, in_name, name),
        nr = IF (in_nr IS NOT NULL, in_nr, nr)
    WHERE id = in_id;
END;

