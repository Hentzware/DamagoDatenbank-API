package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Rolle;
import org.damago.damagodatenbankapi.repositories.RolleRepository;
import org.damago.damagodatenbankapi.requests.rolle.*;
import org.damago.damagodatenbankapi.responses.RolleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class RolleServiceImpl implements RolleService {
    private final RolleRepository rolleRepository;
    private final ModelMapper modelMapper;

    public RolleServiceImpl(RolleRepository rolleRepository, ModelMapper modelMapper) {
        this.rolleRepository = rolleRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public RolleResponse Add(AddRolleRequest request) {
        String id = rolleRepository.sp_Roles_Add(request.getName());
        Rolle rolle = rolleRepository.sp_Roles_GetById(id);
        return modelMapper.map(rolle, RolleResponse.class);
    }

    @Override
    public void Delete(DeleteRolleRequest request, boolean permanent) {
        if (permanent) {
            rolleRepository.sp_Roles_DeletePermanent(request.getId());
            return;
        }
        rolleRepository.sp_Roles_Delete(request.getId());
    }

    @Override
    public RolleResponse Edit(EditRolleRequest request) {
        rolleRepository.sp_Roles_Update(request.getId(), request.getName());
        Rolle rolle = rolleRepository.sp_Roles_GetById(request.getId());
        return modelMapper.map(rolle, RolleResponse.class);
    }

    @Override
    public Iterable<RolleResponse> Get(boolean deleted) {
        Iterable<Rolle> rollen;

        if (deleted) {
            rollen = rolleRepository.sp_Roles_GetDeleted();
        } else {
            rollen = rolleRepository.sp_Roles_Get();
        }

        return modelMapper.map(rollen, new TypeToken<Iterable<RolleResponse>>() {
        }.getType());
    }

    @Override
    public RolleResponse GetById(GetRolleRequest request) {
        Rolle rolle = rolleRepository.sp_Roles_GetById(request.getId());
        return modelMapper.map(rolle, RolleResponse.class);
    }

    @Override
    public Iterable<RolleResponse> Search(SearchRolleRequest request) {
        Iterable<Rolle> rollen = rolleRepository.sp_Roles_Search(request.getName());
        return modelMapper.map(rollen, new TypeToken<Iterable<RolleResponse>>() {
        }.getType());
    }
}
