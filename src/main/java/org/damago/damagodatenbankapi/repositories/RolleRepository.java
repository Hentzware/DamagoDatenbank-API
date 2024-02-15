package org.damago.damagodatenbankapi.repositories;

import org.damago.damagodatenbankapi.entities.Rolle;
import org.damago.damagodatenbankapi.requests.rolle.AddRolleRequest;
import org.damago.damagodatenbankapi.requests.rolle.DeleteRolleRequest;
import org.damago.damagodatenbankapi.requests.rolle.EditRolleRequest;
import org.damago.damagodatenbankapi.requests.rolle.GetRolleRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RolleRepository extends JpaRepository<Rolle, String> {
    @Procedure
    @Transactional(readOnly = true)
    Iterable<Rolle> sp_Roles_Get();

    @Procedure
    @Transactional(readOnly = true)
    Optional<Rolle> sp_Roles_GetById(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Roles_Delete(String id);

    @Procedure
    @Transactional(readOnly = true)
    void sp_Roles_DeletePermanent(String id);

    @Procedure
    @Transactional(readOnly = true)
    Rolle sp_Roles_Add(AddRolleRequest request);

    @Procedure
    @Transactional(readOnly = true)
    Rolle sp_Roles_Update(EditRolleRequest request);
}
