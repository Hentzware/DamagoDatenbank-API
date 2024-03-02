package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Role;
import org.damago.damagodatenbankapi.repositories.RoleRepository;
import org.damago.damagodatenbankapi.requests.role.*;
import org.damago.damagodatenbankapi.responses.RoleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleResponse Add(AddRoleRequest request) {
        String id = roleRepository.sp_Role_Add(request.getName());
        Role role = roleRepository.sp_Role_GetById(id);
        return modelMapper.map(role, RoleResponse.class);
    }

    @Override
    public void Delete(DeleteRoleRequest request, boolean permanent) {
        if (permanent) {
            roleRepository.sp_Role_DeletePermanent(request.getId());
            return;
        }
        roleRepository.sp_Role_Delete(request.getId());
    }

    @Override
    public RoleResponse Edit(EditRoleRequest request) {
        roleRepository.sp_Role_Update(request.getId(), request.getName());
        Role role = roleRepository.sp_Role_GetById(request.getId());
        return modelMapper.map(role, RoleResponse.class);
    }

    @Override
    public Iterable<RoleResponse> Get(boolean deleted) {
        Iterable<Role> roles;

        if (deleted) {
            roles = roleRepository.sp_Role_GetDeleted();
        } else {
            roles = roleRepository.sp_Role_Get();
        }

        return modelMapper.map(roles, new TypeToken<Iterable<RoleResponse>>() {
        }.getType());
    }

    @Override
    public RoleResponse GetById(GetRoleRequest request) {
        Role role = roleRepository.sp_Role_GetById(request.getId());
        return modelMapper.map(role, RoleResponse.class);
    }

    @Override
    public Iterable<RoleResponse> Search(SearchRoleRequest request) {
        Iterable<Role> roles = roleRepository.sp_Role_Search(request.getName());
        return modelMapper.map(roles, new TypeToken<Iterable<RoleResponse>>() {
        }.getType());
    }
}
