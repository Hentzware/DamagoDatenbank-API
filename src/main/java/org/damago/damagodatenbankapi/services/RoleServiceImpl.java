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
        String id = roleRepository.sp_Roles_Add();
        Role role = roleRepository.sp_Roles_GetById(id);
        return modelMapper.map(role, RoleResponse.class);
    }

    @Override
    public void Delete(DeleteRoleRequest request, boolean permanent) {
        if (permanent) {
            roleRepository.sp_Roles_DeletePermanent(request.getId());
            return;
        }
        roleRepository.sp_Roles_Delete(request.getId());
    }

    @Override
    public RoleResponse Edit(EditRoleRequest request) {
        roleRepository.sp_Roles_Update(request.getId());
        Role role = roleRepository.sp_Roles_GetById(request.getId());
        return modelMapper.map(role, RoleResponse.class);
    }

    @Override
    public Iterable<RoleResponse> Get(boolean deleted) {
        Iterable<Role> roles;

        if (deleted) {
            roles = roleRepository.sp_Roles_GetDeleted();
        } else {
            roles = roleRepository.sp_Roles_Get();
        }

        return modelMapper.map(roles, new TypeToken<Iterable<RoleResponse>>() {
        }.getType());
    }

    @Override
    public RoleResponse GetById(GetRoleRequest request) {
        Role role = roleRepository.sp_Roles_GetById(request.getId());
        return modelMapper.map(role, RoleResponse.class);
    }

    @Override
    public Iterable<RoleResponse> Search(SearchRoleRequest request) {
        Iterable<Role> roles = roleRepository.sp_Roles_Search();
        return modelMapper.map(roles, new TypeToken<Iterable<RoleResponse>>() {
        }.getType());
    }
}
