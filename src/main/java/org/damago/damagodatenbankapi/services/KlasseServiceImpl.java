package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Klasse;
import org.damago.damagodatenbankapi.repositories.KlasseRepository;
import org.damago.damagodatenbankapi.requests.klasse.*;
import org.damago.damagodatenbankapi.responses.KlasseResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class KlasseServiceImpl implements KlasseService {
    private final KlasseRepository klasseRepository;
    private final ModelMapper modelMapper;

    public KlasseServiceImpl(KlasseRepository klasseRepository, ModelMapper modelMapper) {
        this.klasseRepository = klasseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public KlasseResponse Add(AddKlasseRequest request) {
        String id = klasseRepository.sp_Classes_Add(request.getName());
        Klasse klasse = klasseRepository.sp_Classes_GetById(id);
        return modelMapper.map(klasse, KlasseResponse.class);
    }

    @Override
    public void Delete(DeleteKlasseRequest request, boolean permanent) {
        if (permanent) {
            klasseRepository.sp_Classes_DeletePermanent(request.getId());
            return;
        }
        klasseRepository.sp_Classes_Delete(request.getId());
    }

    @Override
    public KlasseResponse Edit(EditKlasseRequest request) {
        klasseRepository.sp_Classes_Update(request.getId(), request.getName());
        Klasse klasse = klasseRepository.sp_Classes_GetById(request.getId());
        return modelMapper.map(klasse, KlasseResponse.class);
    }

    @Override
    public Iterable<KlasseResponse> Get(boolean deleted) {
        Iterable<Klasse> klassen;

        if (deleted) {
            klassen = klasseRepository.sp_Classes_GetDeleted();
        } else {
            klassen = klasseRepository.sp_Classes_Get();
        }

        return modelMapper.map(klassen, new TypeToken<Iterable<KlasseResponse>>() {
        }.getType());
    }

    @Override
    public KlasseResponse GetById(GetKlasseRequest request) {
        Klasse klasse = klasseRepository.sp_Classes_GetById(request.getId());
        return modelMapper.map(klasse, KlasseResponse.class);
    }

    @Override
    public Iterable<KlasseResponse> Search(SearchKlasseRequest request) {
        Iterable<Klasse> klassen = klasseRepository.sp_Classes_Search(request.getName());
        return modelMapper.map(klassen, new TypeToken<Iterable<KlasseResponse>>() {
        }.getType());
    }
}
