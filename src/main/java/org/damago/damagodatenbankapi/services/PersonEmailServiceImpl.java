package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.PersonEmail;
import org.damago.damagodatenbankapi.repositories.PersonEmailRepository;
import org.damago.damagodatenbankapi.requests.personEmail.*;
import org.damago.damagodatenbankapi.responses.PersonEmailResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class PersonEmailServiceImpl implements PersonEmailService {
    private final PersonEmailRepository personEmailRepository;
    private final ModelMapper modelMapper;

    public PersonEmailServiceImpl(PersonEmailRepository personEmailRepository, ModelMapper modelMapper) {
        this.personEmailRepository = personEmailRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonEmailResponse Add(AddPersonEmailRequest request) {
        String id = personEmailRepository.sp_PersonEmail_Add(request.getPerson_id(), request.getEmail_id());
        PersonEmail personEmail = personEmailRepository.sp_PersonEmail_GetById(id);

        return modelMapper.map(personEmail, PersonEmailResponse.class);
    }

    @Override
    public void Delete(DeletePersonEmailRequest request, boolean permanent) {
        if (permanent) {
            personEmailRepository.sp_PersonEmail_DeletePermanent(request.getId());
            return;
        }

        personEmailRepository.sp_PersonEmail_Delete(request.getId());
    }

    @Override
    public PersonEmailResponse Edit(EditPersonEmailRequest request) {
        personEmailRepository.sp_PersonEmail_Update(request.getId(), request.getPerson_id(), request.getEmail_id());
        PersonEmail personEmail = personEmailRepository.sp_PersonEmail_GetById(request.getId());

        return modelMapper.map(personEmail, PersonEmailResponse.class);
    }

    @Override
    public Iterable<PersonEmailResponse> Get(boolean deleted) {
        Iterable<PersonEmail> personEmails;

        if (deleted) {
            personEmails = personEmailRepository.sp_PersonEmail_GetDeleted();
        } else {
            personEmails = personEmailRepository.sp_PersonEmail_Get();
        }

        return modelMapper.map(personEmails, new TypeToken<Iterable<PersonEmailResponse>>(){}.getType());
    }

    @Override
    public PersonEmailResponse GetById(GetPersonEmailRequest request) {
        PersonEmail personEmail = personEmailRepository.sp_PersonEmail_GetById(request.getId());

        return modelMapper.map(personEmail, PersonEmailResponse.class);
    }

    @Override
    public Iterable<PersonEmailResponse> Search(SearchPersonEmailRequest request) {
        Iterable<PersonEmail> personEmails = personEmailRepository.sp_PersonEmail_Search(request.getPerson_id(), request.getEmail_id());

        return modelMapper.map(personEmails, new TypeToken<Iterable<PersonEmailResponse>>(){}.getType());
    }
}
