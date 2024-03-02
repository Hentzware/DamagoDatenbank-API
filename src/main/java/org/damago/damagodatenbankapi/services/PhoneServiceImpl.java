package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Phone;
import org.damago.damagodatenbankapi.repositories.PhoneRepository;
import org.damago.damagodatenbankapi.requests.phone.*;
import org.damago.damagodatenbankapi.responses.PhoneResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final ModelMapper modelMapper;

    public PhoneServiceImpl(PhoneRepository phoneRepository, ModelMapper modelMapper) {
        this.phoneRepository = phoneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PhoneResponse Add(AddPhoneRequest request) {
        String id = phoneRepository.sp_Phone_Add(request.getPhone());
        Phone phone = phoneRepository.sp_Phone_GetById(id);
        return modelMapper.map(phone, PhoneResponse.class);
    }

    @Override
    public void Delete(DeletePhoneRequest request, boolean permanent) {
        if (permanent) {
            phoneRepository.sp_Phone_DeletePermanent(request.getId());
            return;
        }
        phoneRepository.sp_Phone_Delete(request.getId());
    }

    @Override
    public PhoneResponse Edit(EditPhoneRequest request) {
        phoneRepository.sp_Phone_Update(request.getId(), request.getPhone());
        Phone phone = phoneRepository.sp_Phone_GetById(request.getId());
        return modelMapper.map(phone, PhoneResponse.class);
    }

    @Override
    public Iterable<PhoneResponse> Get(boolean deleted) {
        Iterable<Phone> phones;

        if (deleted) {
            phones = phoneRepository.sp_Phone_GetDeleted();
        } else {
            phones = phoneRepository.sp_Phone_Get();
        }

        return modelMapper.map(phones, new TypeToken<Iterable<PhoneResponse>>() {
        }.getType());
    }

    @Override
    public PhoneResponse GetById(GetPhoneRequest request) {
        Phone phone = phoneRepository.sp_Phone_GetById(request.getId());
        return modelMapper.map(phone, PhoneResponse.class);
    }

    @Override
    public Iterable<PhoneResponse> Search(SearchPhoneRequest request) {
        Iterable<Phone> phones = phoneRepository.sp_Phone_Search(request.getPhone());
        return modelMapper.map(phones, new TypeToken<Iterable<PhoneResponse>>() {
        }.getType());
    }
}
