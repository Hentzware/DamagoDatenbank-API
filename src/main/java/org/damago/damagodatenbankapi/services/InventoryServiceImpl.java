package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Inventory;
import org.damago.damagodatenbankapi.repositories.InventoryRepository;
import org.damago.damagodatenbankapi.requests.inventory.*;
import org.damago.damagodatenbankapi.responses.InventoryResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventarRepository;
    private final ModelMapper modelMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, ModelMapper modelMapper) {
        this.inventarRepository = inventoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public InventoryResponse Add(AddInventoryRequest request) {
        String id = inventarRepository.sp_Inventory_Add(request.getName(), request.getAmount());
        Inventory inventory = inventarRepository.sp_Inventory_GetById(id);
        return modelMapper.map(inventory, InventoryResponse.class);
    }

    @Override
    public void Delete(DeleteInventoryRequest request, boolean permanent) {
        if (permanent) {
            inventarRepository.sp_Inventory_DeletePermanent(request.getId());
            return;
        }
        inventarRepository.sp_Inventory_Delete(request.getId());
    }

    @Override
    public InventoryResponse Edit(EditInventoryRequest request) {
        inventarRepository.sp_Inventory_Update(request.getId(), request.getName(), request.getAmount());
        Inventory inventory = inventarRepository.sp_Inventory_GetById(request.getId());
        return modelMapper.map(inventory, InventoryResponse.class);
    }

    @Override
    public Iterable<InventoryResponse> Get(boolean deleted) {
        Iterable<Inventory> inventories;

        if (deleted) {
            inventories = inventarRepository.sp_Inventory_GetDeleted();
        } else {
            inventories = inventarRepository.sp_Inventory_Get();
        }

        return modelMapper.map(inventories, new TypeToken<Iterable<InventoryResponse>>() {
        }.getType());
    }

    @Override
    public InventoryResponse GetById(GetInventoryRequest request) {
        Inventory inventory = inventarRepository.sp_Inventory_GetById(request.getId());
        return modelMapper.map(inventory, InventoryResponse.class);
    }

    @Override
    public Iterable<InventoryResponse> Search(SearchInventoryRequest request) {
        Iterable<Inventory> inventories = inventarRepository.sp_Inventory_Search(request.getName(), request.getAmount());
        return modelMapper.map(inventories, new TypeToken<Iterable<InventoryResponse>>() {
        }.getType());
    }
}
