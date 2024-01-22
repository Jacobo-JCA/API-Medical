package com.rest.webservices.medical.controller;

import com.rest.webservices.medical.mapper.PatientMapper;
import com.rest.webservices.medical.dto.PatientDTO;
import com.rest.webservices.medical.model.Patient;
import com.rest.webservices.medical.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper mapper;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> readAll() throws Exception {
        List<PatientDTO> list = patientService.readAll().stream()
                .map(mapper::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Patient obj = patientService.readById(id);
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO dto) throws Exception {
        Patient obj = patientService.save(mapper.convertToEntity(dto));
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable("id") Integer id, @RequestBody PatientDTO dto) throws Exception {
        dto.setIdPatient(id);
        Patient obj = patientService.update(mapper.convertToEntity(dto), id);
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        patientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
