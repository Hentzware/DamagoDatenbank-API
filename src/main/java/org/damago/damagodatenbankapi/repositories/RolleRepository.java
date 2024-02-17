package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Rolle;
import org.damago.damagodatenbankapi.requests.rolle.AddRolleRequest;
import org.damago.damagodatenbankapi.requests.rolle.EditRolleRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface RolleRepository extends JpaRepository<Rolle, String> {
    @Procedure
    Rolle sp_Roles_Add(AddRolleRequest request);

    @Procedure
    void sp_Roles_Delete(String id);

    @Procedure
    void sp_Roles_DeletePermanent(String id);

    @Procedure
    Iterable<Rolle> sp_Roles_Get();

    @Procedure
    Optional<Rolle> sp_Roles_GetById(String id);

    @Procedure
    Iterable<Rolle> sp_Roles_GetByName(String name);

    @Procedure
    Iterable<Rolle> sp_Roles_GetDeleted();

    @Procedure
    Rolle sp_Roles_Update(EditRolleRequest request);
}
