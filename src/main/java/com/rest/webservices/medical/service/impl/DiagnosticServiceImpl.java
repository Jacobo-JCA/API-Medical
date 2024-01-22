package com.rest.webservices.medical.service.impl;

import com.rest.webservices.medical.model.Diagnostic;
import com.rest.webservices.medical.repository.DiagnosticRepo;
import com.rest.webservices.medical.repository.GenericRepo;
import com.rest.webservices.medical.service.DiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosticServiceImpl extends CRUDImpl<Diagnostic, Integer> implements DiagnosticService {

    private final DiagnosticRepo diagnosticRepo;
    @Override
    protected GenericRepo<Diagnostic, Integer> getRepo() {
        return diagnosticRepo;
    }
}
