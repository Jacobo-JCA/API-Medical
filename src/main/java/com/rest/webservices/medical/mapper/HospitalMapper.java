package com.rest.webservices.medical.mapper;

import com.rest.webservices.medical.dto.HospitalDTO;
import com.rest.webservices.medical.model.Hospital;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HospitalMapper {

    private final ModelMapper mapper;

    public HospitalDTO convertToDTO(Hospital obj) {
        return mapper.map(obj, HospitalDTO.class);
    }
    public Hospital convertToEntity(HospitalDTO dto) {
        return mapper.map(dto, Hospital.class);
    }
}
