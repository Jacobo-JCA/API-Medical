package com.rest.webservices.medical.mapper;

import com.rest.webservices.medical.dto.PatientDTO;
import com.rest.webservices.medical.model.Patient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PatientMapper {

    private final ModelMapper mapper;

    public PatientDTO convertToDTO(Patient obj) {
        return mapper.map(obj, PatientDTO.class);
    }
    public Patient convertToEntity(PatientDTO dto) {
        return mapper.map(dto, Patient.class);
    }
}
