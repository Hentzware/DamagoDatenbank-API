package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonRole;
import org.damago.damagodatenbankapi.repositories.PersonRoleRepository;
import org.damago.damagodatenbankapi.requests.personRole.*;
import org.damago.damagodatenbankapi.responses.PersonRoleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonRoleServiceImpl implements PersonRoleService {
    private final PersonRoleRepository personRoleRepository;
    private final ModelMapper modelMapper;

    public PersonRoleServiceImpl(PersonRoleRepository personRoleRepository, ModelMapper modelMapper) {
        this.personRoleRepository = personRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonRoleResponse Add(AddPersonRoleRequest request) {
        String id = personRoleRepository.sp_PersonRole_Add(request.getPerson_id(), request.getRole_id());
        PersonRole personRole = personRoleRepository.sp_PersonRole_GetById(id);
        return modelMapper.map(personRole, PersonRoleResponse.class);
    }

    @Override
    public void Delete(DeletePersonRoleRequest request, boolean permanent) {
        if (permanent) {
            personRoleRepository.sp_PersonRole_DeletePermanent(request.getId());
            return;
        }
        personRoleRepository.sp_PersonRole_Delete(request.getId());
    }

    @Override
    public PersonRoleResponse Edit(EditPersonRoleRequest request) {
        personRoleRepository.sp_PersonRole_Update(request.getId(), request.getPerson_id(), request.getRole_id());
        PersonRole personRole = personRoleRepository.sp_PersonRole_GetById(request.getId());
        return modelMapper.map(personRole, PersonRoleResponse.class);
    }

    @Override
    public Iterable<PersonRoleResponse> Get(boolean deleted) {
        Iterable<PersonRole> personsRoles;

        if (deleted) {
            personsRoles = personRoleRepository.sp_PersonRole_GetDeleted();
        } else {
            personsRoles = personRoleRepository.sp_PersonRole_Get();
        }

        return modelMapper.map(personsRoles, new TypeToken<Iterable<PersonRoleResponse>>() {
        }.getType());
    }

    @Override
    public PersonRoleResponse GetById(GetPersonRoleRequest request) {
        PersonRole personRole = personRoleRepository.sp_PersonRole_GetById(request.getId());
        return modelMapper.map(personRole, PersonRoleResponse.class);
    }

    @Override
    public Iterable<PersonRoleResponse> Search(SearchPersonRoleRequest request) {
        Iterable<PersonRole> personsRoles = personRoleRepository.sp_PersonRole_Search(request.getPerson_id(), request.getRole_id());
        return modelMapper.map(personsRoles, new TypeToken<Iterable<PersonRoleResponse>>() {
        }.getType());
    }
}
