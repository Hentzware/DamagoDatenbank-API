package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Inventar;
import org.damago.damagodatenbankapi.repositories.InventarRepository;
import org.damago.damagodatenbankapi.requests.inventar.*;
import org.damago.damagodatenbankapi.responses.InventarResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class InventarServiceImpl implements  InventarService {
    private final InventarRepository inventarRepository;
    private final ModelMapper modelMapper;

    public InventarServiceImpl(InventarRepository inventarRepository, ModelMapper modelMapper) {
        this.inventarRepository = inventarRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public InventarResponse Add(AddInventarRequest request) {
        String id = inventarRepository.sp_Inventory_Add(request.getName(), request.getAnzahl());
        Inventar inventar = inventarRepository.sp_Inventory_GetById(id);
        return modelMapper.map(inventar, InventarResponse.class);
    }

    @Override
    public void Delete(DeleteInventarRequest request, boolean permanent) {
        if (permanent) {
            inventarRepository.sp_Inventory_DeletePermanent(request.getId());
            return;
        }
        inventarRepository.sp_Inventory_Delete(request.getId());
    }

    @Override
    public InventarResponse Edit(EditInventarRequest request) {
        inventarRepository.sp_Inventory_Update(request.getId(), request.getName(), request.getAnzahl());
        Inventar inventar = inventarRepository.sp_Inventory_GetById(request.getId());
        return modelMapper.map(inventar, InventarResponse.class);
    }

    @Override
    public Iterable<InventarResponse> Get(boolean deleted) {
        Iterable<Inventar> inventar;

        if (deleted) {
            inventar = inventarRepository.sp_Inventory_GetDeleted();
        } else {
            inventar = inventarRepository.sp_Inventory_Get();
        }

        return modelMapper.map(inventar, new TypeToken<Iterable<InventarResponse>>() {
        }.getType());
    }

    @Override
    public InventarResponse GetById(GetInventarRequest request) {
        Inventar inventar = inventarRepository.sp_Inventory_GetById(request.getId());
        return modelMapper.map(inventar, InventarResponse.class);
    }

    @Override
    public Iterable<InventarResponse> Search(SearchInventarRequest request) {
        Iterable<Inventar> inventar = inventarRepository.sp_Inventory_Search(request.getName(), request.getAnzahl());
        return modelMapper.map(inventar, new TypeToken<Iterable<InventarResponse>>() {
        }.getType());
    }
}
