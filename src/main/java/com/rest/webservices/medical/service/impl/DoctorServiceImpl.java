package com.rest.webservices.medical.service.impl;

import com.rest.webservices.medical.model.Doctor;
import com.rest.webservices.medical.repository.DoctorRepo;
import com.rest.webservices.medical.repository.GenericRepo;
import com.rest.webservices.medical.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl extends CRUDImpl<Doctor, Integer> implements DoctorService {

    private final DoctorRepo doctorRepo;
    @Override
    protected GenericRepo<Doctor, Integer> getRepo() {
        return doctorRepo;
    }
}
