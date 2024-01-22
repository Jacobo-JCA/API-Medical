package com.rest.webservices.medical.service.impl;

import com.rest.webservices.medical.model.Patient;
import com.rest.webservices.medical.repository.GenericRepo;
import com.rest.webservices.medical.repository.PatientRepo;
import com.rest.webservices.medical.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements PatientService {

    private final PatientRepo patientRepo;
    @Override
    protected GenericRepo<Patient, Integer> getRepo() {
        return patientRepo;
    }
}
