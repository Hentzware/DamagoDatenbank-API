package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Adresse;
import org.damago.damagodatenbankapi.repositories.AdresseRepository;
import org.damago.damagodatenbankapi.requests.adresse.*;
import org.damago.damagodatenbankapi.responses.AdresseResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class AdresseServiceImpl implements AdresseService{
    private final AdresseRepository adresseRepository;
    private final ModelMapper modelMapper;

    public AdresseServiceImpl(AdresseRepository adresseRepository, ModelMapper modelMapper) {
        this.adresseRepository = adresseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdresseResponse Add(AddAdresseRequest request) {
        String id = adresseRepository.sp_Adresses_Add(request.getStrasse(), request.getHausnummer(), request.getPostleitzahl(), request.getOrt(), request.getLand());
        Adresse adresse = adresseRepository.sp_Adresses_GetById(id);
        return modelMapper.map(adresse, AdresseResponse.class);
    }

    @Override
    public void Delete(DeleteAdresseRequest request, boolean permanent) {
        if (permanent) {
            adresseRepository.sp_Adresses_DeletePermanent(request.getId());
            return;
        }
        adresseRepository.sp_Adresses_Delete(request.getId());
    }

    @Override
    public AdresseResponse Edit(EditAdresseRequest request) {
        adresseRepository.sp_Adresses_Update(request.getId(), request.getStrasse(), request.getHausnummer(), request.getPostleitzahl(), request.getOrt(), request.getLand());
        Adresse adresse = adresseRepository.sp_Adresses_GetById(request.getId());
        return modelMapper.map(adresse, AdresseResponse.class);
    }

    @Override
    public Iterable<AdresseResponse> Get(boolean deleted) {
        Iterable<Adresse> adressen;

        if (deleted) {
            adressen = adresseRepository.sp_Adresses_GetDeleted();
        } else {
            adressen = adresseRepository.sp_Adresses_Get();
        }

        return modelMapper.map(adressen, new TypeToken<Iterable<AdresseResponse>>() {
        }.getType());
    }

    @Override
    public AdresseResponse GetById(GetAdresseRequest request) {
        Adresse adresse = adresseRepository.sp_Adresses_GetById(request.getId());
        return modelMapper.map(adresse, AdresseResponse.class);
    }

    @Override
    public Iterable<AdresseResponse> Search(SearchAdresseRequest request) {
        Iterable<Adresse> adressen = adresseRepository.sp_Adresses_Search(request.getStrasse(), request.getHausnummer(), request.getPostleitzahl(), request.getOrt(), request.getLand());
        return modelMapper.map(adressen, new TypeToken<Iterable<AdresseResponse>>() {
        }.getType());
    }
}
