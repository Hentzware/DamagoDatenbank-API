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
        String id = moduleSchoolClassRepository.sp_ModuleSchoolClass_Add(request.getModule_id(), request.getSchool_class_id());
        ModuleSchoolClass moduleSchoolClass = moduleSchoolClassRepository.sp_ModuleSchoolClass_GetById(id);
        return modelMapper.map(moduleSchoolClass, ModuleSchoolClassResponse.class);
    }

    @Override
    public void Delete(DeleteModuleSchoolClassRequest request, boolean permanent) {
        if (permanent) {
            moduleSchoolClassRepository.sp_ModuleSchoolClass_DeletePermanent(request.getId());
            return;
        }
        moduleSchoolClassRepository.sp_ModuleSchoolClass_Delete(request.getId());
    }

    @Override
    public ModuleSchoolClassResponse Edit(EditModuleSchoolClassRequest request) {
        moduleSchoolClassRepository.sp_ModuleSchoolClass_Update(request.getId(), request.getModule_id(), request.getSchool_class_id());
        ModuleSchoolClass moduleSchoolClass = moduleSchoolClassRepository.sp_ModuleSchoolClass_GetById(request.getId());
        return modelMapper.map(moduleSchoolClass, ModuleSchoolClassResponse.class);
    }

    @Override
    public Iterable<ModuleSchoolClassResponse> Get(boolean deleted) {
        Iterable<ModuleSchoolClass> modulesSchoolClasses;

        if (deleted) {
            modulesSchoolClasses = moduleSchoolClassRepository.sp_ModuleSchoolClass_GetDeleted();
        } else {
            modulesSchoolClasses = moduleSchoolClassRepository.sp_ModuleSchoolClass_Get();
        }

        return modelMapper.map(modulesSchoolClasses, new TypeToken<Iterable<ModuleSchoolClassResponse>>() {
        }.getType());
    }

    @Override
    public ModuleSchoolClassResponse GetById(GetModuleSchoolClassRequest request) {
        ModuleSchoolClass moduleSchoolClass = moduleSchoolClassRepository.sp_ModuleSchoolClass_GetById(request.getId());
        return modelMapper.map(moduleSchoolClass, ModuleSchoolClassResponse.class);
    }

    @Override
    public Iterable<ModuleSchoolClassResponse> Search(SearchModuleSchoolClassRequest request) {
        Iterable<ModuleSchoolClass> modulesSchoolClasses = moduleSchoolClassRepository.sp_ModuleSchoolClass_Search(request.getModule_id(), request.getSchool_class_id());
        return modelMapper.map(modulesSchoolClasses, new TypeToken<Iterable<ModuleSchoolClassResponse>>() {
        }.getType());
    }
}
