package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Modul;
import org.damago.damagodatenbankapi.repositories.ModulRepository;
import org.damago.damagodatenbankapi.requests.modul.*;
import org.damago.damagodatenbankapi.responses.ModulResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class ModulServiceImpl implements ModulService {
    private final ModulRepository modulRepository;
    private final ModelMapper modelMapper;

    public ModulServiceImpl(ModulRepository modulRepository, ModelMapper modelMapper) {
        this.modulRepository = modulRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModulResponse Add(AddModulRequest request) {
        String id = modulRepository.sp_Module_Add(request.getName(), request.getDauer());
        Modul modul = modulRepository.sp_Module_GetById(id);
        return modelMapper.map(modul, ModulResponse.class);
    }

    @Override
    public void Delete(DeleteModulRequest request, boolean permanent) {
        if (permanent) {
            modulRepository.sp_Module_DeletePermanent(request.getId());
            return;
        }
        modulRepository.sp_Module_Delete(request.getId());
    }

    @Override
    public ModulResponse Edit(EditModulRequest request) {
        modulRepository.sp_Module_Update(request.getId(), request.getName(), request.getDauer());
        Modul modul = modulRepository.sp_Module_GetById(request.getId());
        return modelMapper.map(modul, ModulResponse.class);
    }

    @Override
    public Iterable<ModulResponse> Get(boolean deleted) {
        Iterable<Modul> modul;

        if (deleted) {
            modul = modulRepository.sp_Module_GetDeleted();
        } else {
            modul = modulRepository.sp_Module_Get();
        }

        return modelMapper.map(modul, new TypeToken<Iterable<ModulResponse>>() {
        }.getType());
    }

    @Override
    public ModulResponse GetById(GetModulRequest request) {
        Modul modul = modulRepository.sp_Module_GetById(request.getId());
        return modelMapper.map(modul, ModulResponse.class);
    }

    @Override
    public Iterable<ModulResponse> Search(SearchModulRequest request) {
        Iterable<Modul> modul = modulRepository.sp_Module_Search(request.getName());
        return modelMapper.map(modul, new TypeToken<Iterable<ModulResponse>>() {
        }.getType());
    }
}
