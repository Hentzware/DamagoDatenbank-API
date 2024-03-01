package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.ModuleSchoolClass;
import org.damago.damagodatenbankapi.repositories.ModuleSchoolClassRepository;
import org.damago.damagodatenbankapi.requests.moduleSchoolClass.*;
import org.damago.damagodatenbankapi.responses.ModuleSchoolClassResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class ModuleSchoolClassServiceImpl implements ModuleSchoolClassService {
    private final ModuleSchoolClassRepository moduleSchoolClassRepository;
    private final ModelMapper modelMapper;

    public ModuleSchoolClassServiceImpl(ModuleSchoolClassRepository moduleSchoolClassRepository, ModelMapper modelMapper) {
        this.moduleSchoolClassRepository = moduleSchoolClassRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModuleSchoolClassResponse Add(AddModuleSchoolClassRequest request) {
        String id = moduleSchoolClassRepository.sp_ModulesSchoolClasses_Add();
        ModuleSchoolClass moduleSchoolClass = moduleSchoolClassRepository.sp_ModulesSchoolClasses_GetById(id);
        return modelMapper.map(moduleSchoolClass, ModuleSchoolClassResponse.class);
    }

    @Override
    public void Delete(DeleteModuleSchoolClassRequest request, boolean permanent) {
        if (permanent) {
            moduleSchoolClassRepository.sp_ModulesSchoolClasses_DeletePermanent(request.getId());
            return;
        }
        moduleSchoolClassRepository.sp_ModulesSchoolClasses_Delete(request.getId());
    }

    @Override
    public ModuleSchoolClassResponse Edit(EditModuleSchoolClassRequest request) {
        moduleSchoolClassRepository.sp_ModulesSchoolClasses_Update(request.getId());
        ModuleSchoolClass moduleSchoolClass = moduleSchoolClassRepository.sp_ModulesSchoolClasses_GetById(request.getId());
        return modelMapper.map(moduleSchoolClass, ModuleSchoolClassResponse.class);
    }

    @Override
    public Iterable<ModuleSchoolClassResponse> Get(boolean deleted) {
        Iterable<ModuleSchoolClass> modulesSchoolClasses;

        if (deleted) {
            modulesSchoolClasses = moduleSchoolClassRepository.sp_ModulesSchoolClasses_GetDeleted();
        } else {
            modulesSchoolClasses = moduleSchoolClassRepository.sp_ModulesSchoolClasses_Get();
        }

        return modelMapper.map(modulesSchoolClasses, new TypeToken<Iterable<ModuleSchoolClassResponse>>() {
        }.getType());
    }

    @Override
    public ModuleSchoolClassResponse GetById(GetModuleSchoolClassRequest request) {
        ModuleSchoolClass moduleSchoolClass = moduleSchoolClassRepository.sp_ModulesSchoolClasses_GetById(request.getId());
        return modelMapper.map(moduleSchoolClass, ModuleSchoolClassResponse.class);
    }

    @Override
    public Iterable<ModuleSchoolClassResponse> Search(SearchModuleSchoolClassRequest request) {
        Iterable<ModuleSchoolClass> modulesSchoolClasses = moduleSchoolClassRepository.sp_ModulesSchoolClasses_Search();
        return modelMapper.map(modulesSchoolClasses, new TypeToken<Iterable<ModuleSchoolClassResponse>>() {
        }.getType());
    }
}
