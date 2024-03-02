package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.ModulePerson;
import org.damago.damagodatenbankapi.repositories.ModulePersonRepository;
import org.damago.damagodatenbankapi.requests.modulePerson.*;
import org.damago.damagodatenbankapi.responses.ModulePersonResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class ModulePersonServiceImpl implements ModulePersonService {
    private final ModulePersonRepository modulePersonRepository;
    private final ModelMapper modelMapper;

    public ModulePersonServiceImpl(ModulePersonRepository modulePersonRepository, ModelMapper modelMapper) {
        this.modulePersonRepository = modulePersonRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModulePersonResponse Add(AddModulePersonRequest request) {
        String id = modulePersonRepository.sp_ModulePerson_Add(request.getModule_id(), request.getPerson_id());
        ModulePerson modulePerson = modulePersonRepository.sp_ModulePerson_GetById(id);
        return modelMapper.map(modulePerson, ModulePersonResponse.class);
    }

    @Override
    public void Delete(DeleteModulePersonRequest request, boolean permanent) {
        if (permanent) {
            modulePersonRepository.sp_ModulePerson_DeletePermanent(request.getId());
            return;
        }
        modulePersonRepository.sp_ModulePerson_Delete(request.getId());
    }

    @Override
    public ModulePersonResponse Edit(EditModulePersonRequest request) {
        modulePersonRepository.sp_ModulePerson_Update(request.getId(), request.getModule_id(), request.getPerson_id());
        ModulePerson modulePerson = modulePersonRepository.sp_ModulePerson_GetById(request.getId());
        return modelMapper.map(modulePerson, ModulePersonResponse.class);
    }

    @Override
    public Iterable<ModulePersonResponse> Get(boolean deleted) {
        Iterable<ModulePerson> modulesPersons;

        if (deleted) {
            modulesPersons = modulePersonRepository.sp_ModulePerson_GetDeleted();
        } else {
            modulesPersons = modulePersonRepository.sp_ModulePerson_Get();
        }

        return modelMapper.map(modulesPersons, new TypeToken<Iterable<ModulePersonResponse>>() {
        }.getType());
    }

    @Override
    public ModulePersonResponse GetById(GetModulePersonRequest request) {
        ModulePerson modulePerson = modulePersonRepository.sp_ModulePerson_GetById(request.getId());
        return modelMapper.map(modulePerson, ModulePersonResponse.class);
    }

    @Override
    public Iterable<ModulePersonResponse> Search(SearchModulePersonRequest request) {
        Iterable<ModulePerson> modulesPersons = modulePersonRepository.sp_ModulePerson_Search(request.getModule_id(), request.getPerson_id());
        return modelMapper.map(modulesPersons, new TypeToken<Iterable<ModulePersonResponse>>() {
        }.getType());
    }
}
