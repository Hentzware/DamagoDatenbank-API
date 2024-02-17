package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Telefonnummer;
import org.damago.damagodatenbankapi.repositories.TelefonnummerRepository;
import org.damago.damagodatenbankapi.requests.telefonnummer.AddTelefonnummerRequest;
import org.damago.damagodatenbankapi.requests.telefonnummer.DeleteTelefonnummerRequest;
import org.damago.damagodatenbankapi.requests.telefonnummer.EditTelefonnummerRequest;
import org.damago.damagodatenbankapi.requests.telefonnummer.GetTelefonnummerRequest;
import org.damago.damagodatenbankapi.responses.TelefonnummerResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class TelefonnummerServiceImpl implements TelefonnummerService {
    private final ModelMapper modelMapper;
    private final TelefonnummerRepository telefonnummerRepository;

    public TelefonnummerServiceImpl(TelefonnummerRepository telefonnummerRepository, ModelMapper modelMapper) {
        this.telefonnummerRepository = telefonnummerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TelefonnummerResponse Add(AddTelefonnummerRequest request) {
        String id = telefonnummerRepository.sp_Phones_Add(request.getTelefonnummer());
        Telefonnummer telefonnummer = telefonnummerRepository.sp_Phones_GetById(id);

        return modelMapper.map(telefonnummer, TelefonnummerResponse.class);
    }

    @Override
    public void Delete(DeleteTelefonnummerRequest request, boolean permanent) {
        if (permanent) {
            telefonnummerRepository.sp_Phones_DeletePermanent(request.getId());
            return;
        }
        telefonnummerRepository.sp_Phones_Delete(request.getId());
    }

    @Override
    public TelefonnummerResponse Edit(EditTelefonnummerRequest request) {
        telefonnummerRepository.sp_Phones_Update(request.getId(), request.getTelefonnummer());
        Telefonnummer telefonnummer = telefonnummerRepository.sp_Phones_GetById(request.getId());
        return modelMapper.map(telefonnummer, TelefonnummerResponse.class);
    }

    @Override
    public Iterable<TelefonnummerResponse> Get(boolean deleted) {
        Iterable<Telefonnummer> telefonnummern;

        if (deleted) {
            telefonnummern = telefonnummerRepository.sp_Phones_GetDeleted();
        } else {
            telefonnummern = telefonnummerRepository.sp_Phones_Get();
        }
        return modelMapper.map(telefonnummern, new TypeToken<Iterable<TelefonnummerResponse>>(){}.getType());
    }

    @Override
    public TelefonnummerResponse GetById(GetTelefonnummerRequest request) {
        Telefonnummer telefonnummer = telefonnummerRepository.sp_Phones_GetById(request.getId());
        return modelMapper.map(telefonnummer, TelefonnummerResponse.class);
    }

    @Override
    public Iterable<TelefonnummerResponse> Search(String telefonnummer) {
        Iterable<Telefonnummer> telefonnummern = telefonnummerRepository.sp_Phones_Search(telefonnummer);
        return modelMapper.map(telefonnummern, new TypeToken<Iterable<TelefonnummerResponse>>(){}.getType());
    }
}
