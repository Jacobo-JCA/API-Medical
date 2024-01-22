package com.rest.webservices.medical.controller;

import com.rest.webservices.medical.mapper.DiagnosticMapper;
import com.rest.webservices.medical.dto.DiagnosticDTO;
import com.rest.webservices.medical.model.Diagnostic;
import com.rest.webservices.medical.service.DiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diagnostics")
public class DiagnosticController {

    private final DiagnosticService diagnosticService;
    private final DiagnosticMapper mapper;

    @GetMapping
    public ResponseEntity<List<DiagnosticDTO>> readAll() throws Exception {
        List<DiagnosticDTO> list = diagnosticService.readAll().stream()
                .map(mapper::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DiagnosticDTO> save(@RequestBody DiagnosticDTO dto) throws Exception {
        Diagnostic obj = diagnosticService.save(mapper.convertToEntity(dto));
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        diagnosticService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
