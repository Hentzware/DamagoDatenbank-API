CREATE PROCEDURE sp_PersonRole_Search (IN in_personId VARCHAR(36), IN in_RolleId VARCHAR(36))
BEGIN
    SELECT * FROM person_role
        WHERE (person_id = in_personId OR in_personId IS NULL)
          AND (role_id = in_RolleId OR in_RolleId IS NULL);
END