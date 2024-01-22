package com.rest.webservices.medical.mapper;

import com.rest.webservices.medical.dto.DiagnosticDTO;
import com.rest.webservices.medical.model.Diagnostic;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiagnosticMapper {

    private final ModelMapper mapper;
    public DiagnosticDTO convertToDTO(Diagnostic obj) {
        return mapper.map(obj, DiagnosticDTO.class);
    }
    public Diagnostic convertToEntity(DiagnosticDTO dto) {
        return mapper.map(dto, Diagnostic.class);
    }
}

