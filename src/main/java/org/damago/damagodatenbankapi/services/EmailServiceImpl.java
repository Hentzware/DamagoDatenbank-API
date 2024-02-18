package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.Adresse;
import org.damago.damagodatenbankapi.entities.Email;
import org.damago.damagodatenbankapi.repositories.EmailRepository;
import org.damago.damagodatenbankapi.requests.email.*;
import org.damago.damagodatenbankapi.responses.AdresseResponse;
import org.damago.damagodatenbankapi.responses.EmailResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;
    private final ModelMapper modelMapper;

    public EmailServiceImpl(EmailRepository emailRepository, ModelMapper modelMapper) {
        this.emailRepository = emailRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmailResponse Add(AddEmailRequest request) {
        String id = emailRepository.sp_Emails_Add(request.getEmail());
        Email email = emailRepository.sp_Emails_GetById(id);
        return modelMapper.map(email, EmailResponse.class);
    }

    @Override
    public void Delete(DeleteEmailRequest request, boolean permanent) {
        if (permanent) {
            emailRepository.sp_Emails_DeletePermanent(request.getId());
            return;
        }
        emailRepository.sp_Emails_Delete(request.getId());
    }

    @Override
    public EmailResponse Edit(EditEmailRequest request) {
        emailRepository.sp_Emails_Update(request.getId(), request.getEmail());
        Email email = emailRepository.sp_Emails_GetById(request.getId());
        return modelMapper.map(email, EmailResponse.class);
    }

    @Override
    public Iterable<EmailResponse> Get(boolean deleted) {
        Iterable<Email> emails;

        if (deleted) {
            emails = emailRepository.sp_Emails_GetDeleted();
        } else {
            emails = emailRepository.sp_Emails_Get();
        }

        return modelMapper.map(emails, new TypeToken<Iterable<EmailResponse>>() {
        }.getType());
    }

    @Override
    public EmailResponse GetById(GetEmailRequest request) {
        Email email = emailRepository.sp_Emails_GetById(request.getId());
        return modelMapper.map(email, EmailResponse.class);
    }

    @Override
    public Iterable<EmailResponse> Search(SearchEmailRequest request) {
        Iterable<Email> emails = emailRepository.sp_Emails_Search(request.getEmail());
        return modelMapper.map(emails, new TypeToken<Iterable<EmailResponse>>() {
        }.getType());
    }
}
