package org.damago.damagodatenbankapi.services;

import org.damago.damagodatenbankapi.entities.SchoolClass;
import org.damago.damagodatenbankapi.repositories.SchoolClassRepository;
import org.damago.damagodatenbankapi.requests.schoolClass.*;
import org.damago.damagodatenbankapi.responses.SchoolClassResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;
    private final ModelMapper modelMapper;

    public SchoolClassServiceImpl(SchoolClassRepository schoolClassRepository, ModelMapper modelMapper) {
        this.schoolClassRepository = schoolClassRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SchoolClassResponse Add(AddSchoolClassRequest request) {
        String id = schoolClassRepository.sp_SchoolClasses_Add(request.getName());
        SchoolClass schoolClass = schoolClassRepository.sp_SchoolClasses_GetById(id);
        return modelMapper.map(schoolClass, SchoolClassResponse.class);
    }

    @Override
    public void Delete(DeleteSchoolClassRequest request, boolean permanent) {
        if (permanent) {
            schoolClassRepository.sp_SchoolClasses_DeletePermanent(request.getId());
            return;
        }
        schoolClassRepository.sp_SchoolClasses_Delete(request.getId());
    }

    @Override
    public SchoolClassResponse Edit(EditSchoolClassRequest request) {
        schoolClassRepository.sp_SchoolClasses_Update(request.getId(), request.getName());
        SchoolClass schoolClass = schoolClassRepository.sp_SchoolClasses_GetById(request.getId());
        return modelMapper.map(schoolClass, SchoolClassResponse.class);
    }

    @Override
    public Iterable<SchoolClassResponse> Get(boolean deleted) {
        Iterable<SchoolClass> schoolClasses;

        if (deleted) {
            schoolClasses = schoolClassRepository.sp_SchoolClasses_GetDeleted();
        } else {
            schoolClasses = schoolClassRepository.sp_SchoolClasses_Get();
        }

        return modelMapper.map(schoolClasses, new TypeToken<Iterable<SchoolClassResponse>>() {
        }.getType());
    }

    @Override
    public SchoolClassResponse GetById(GetSchoolClassRequest request) {
        SchoolClass schoolClass = schoolClassRepository.sp_SchoolClasses_GetById(request.getId());
        return modelMapper.map(schoolClass, SchoolClassResponse.class);
    }

    @Override
    public Iterable<SchoolClassResponse> Search(SearchSchoolClassRequest request) {
        Iterable<SchoolClass> schoolClasses = schoolClassRepository.sp_SchoolClasses_Search(request.getName());
        return modelMapper.map(schoolClasses, new TypeToken<Iterable<SchoolClassResponse>>() {
        }.getType());
    }
}
