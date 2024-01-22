package com.rest.webservices.medical.service.impl;

import com.rest.webservices.medical.model.Hospital;
import com.rest.webservices.medical.repository.GenericRepo;
import com.rest.webservices.medical.repository.HospitalRepo;
import com.rest.webservices.medical.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl extends CRUDImpl<Hospital, Integer> implements HospitalService {

    private final HospitalRepo hospitalRepo;
    @Override
    protected GenericRepo<Hospital, Integer> getRepo() {
        return hospitalRepo;
    }
}
