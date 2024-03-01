package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Module;
import org.damago.damagodatenbankapi.repositories.ModuleRepository;
import org.damago.damagodatenbankapi.requests.module.*;
import org.damago.damagodatenbankapi.responses.ModuleResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final ModelMapper modelMapper;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModelMapper modelMapper) {
        this.moduleRepository = moduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModuleResponse Add(AddModuleRequest request) {
        String id = moduleRepository.sp_Modules_Add();
        Module module = moduleRepository.sp_Modules_GetById(id);
        return modelMapper.map(module, ModuleResponse.class);
    }

    @Override
    public void Delete(DeleteModuleRequest request, boolean permanent) {
        if (permanent) {
            moduleRepository.sp_Modules_DeletePermanent(request.getId());
            return;
        }
        moduleRepository.sp_Modules_Delete(request.getId());
    }

    @Override
    public ModuleResponse Edit(EditModuleRequest request) {
        moduleRepository.sp_Modules_Update(request.getId());
        Module module = moduleRepository.sp_Modules_GetById(request.getId());
        return modelMapper.map(module, ModuleResponse.class);
    }

    @Override
    public Iterable<ModuleResponse> Get(boolean deleted) {
        Iterable<Module> modules;

        if (deleted) {
            modules = moduleRepository.sp_Modules_GetDeleted();
        } else {
            modules = moduleRepository.sp_Modules_Get();
        }

        return modelMapper.map(modules, new TypeToken<Iterable<ModuleResponse>>() {
        }.getType());
    }

    @Override
    public ModuleResponse GetById(GetModuleRequest request) {
        Module module = moduleRepository.sp_Modules_GetById(request.getId());
        return modelMapper.map(module, ModuleResponse.class);
    }

    @Override
    public Iterable<ModuleResponse> Search(SearchModuleRequest request) {
        Iterable<Module> modules = moduleRepository.sp_Modules_Search();
        return modelMapper.map(modules, new TypeToken<Iterable<ModuleResponse>>() {
        }.getType());
    }
}
