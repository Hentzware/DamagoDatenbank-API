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
        String id = modulePersonRepository.sp_ModulesPersons_Add();
        ModulePerson modulePerson = modulePersonRepository.sp_ModulesPersons_GetById(id);
        return modelMapper.map(modulePerson, ModulePersonResponse.class);
    }

    @Override
    public void Delete(DeleteModulePersonRequest request, boolean permanent) {
        if (permanent) {
            modulePersonRepository.sp_ModulesPersons_DeletePermanent(request.getId());
            return;
        }
        modulePersonRepository.sp_ModulesPersons_Delete(request.getId());
    }

    @Override
    public ModulePersonResponse Edit(EditModulePersonRequest request) {
        modulePersonRepository.sp_ModulesPersons_Update(request.getId());
        ModulePerson modulePerson = modulePersonRepository.sp_ModulesPersons_GetById(request.getId());
        return modelMapper.map(modulePerson, ModulePersonResponse.class);
    }

    @Override
    public Iterable<ModulePersonResponse> Get(boolean deleted) {
        Iterable<ModulePerson> modulesPersons;

        if (deleted) {
            modulesPersons = modulePersonRepository.sp_ModulesPersons_GetDeleted();
        } else {
            modulesPersons = modulePersonRepository.sp_ModulesPersons_Get();
        }

        return modelMapper.map(modulesPersons, new TypeToken<Iterable<ModulePersonResponse>>() {
        }.getType());
    }

    @Override
    public ModulePersonResponse GetById(GetModulePersonRequest request) {
        ModulePerson modulePerson = modulePersonRepository.sp_ModulesPersons_GetById(request.getId());
        return modelMapper.map(modulePerson, ModulePersonResponse.class);
    }

    @Override
    public Iterable<ModulePersonResponse> Search(SearchModulePersonRequest request) {
        Iterable<ModulePerson> modulesPersons = modulePersonRepository.sp_ModulesPersons_Search();
        return modelMapper.map(modulesPersons, new TypeToken<Iterable<ModulePersonResponse>>() {
        }.getType());
    }
}
