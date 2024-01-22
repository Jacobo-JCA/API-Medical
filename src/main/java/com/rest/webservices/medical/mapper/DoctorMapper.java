package com.rest.webservices.medical.mapper;

import com.rest.webservices.medical.dto.DoctorDTO;
import com.rest.webservices.medical.model.Doctor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DoctorMapper {

    private final ModelMapper mapper;

    public DoctorDTO convertToDTO(Doctor obj) {
        return mapper.map(obj, DoctorDTO.class);
    }
    public Doctor convertToEntity(DoctorDTO dto) {
        return mapper.map(dto, Doctor.class);
    }
}
