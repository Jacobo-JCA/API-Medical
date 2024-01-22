package com.rest.webservices.medical.controller;

import com.rest.webservices.medical.dto.DoctorDTO;
import com.rest.webservices.medical.dto.HospitalDTO;
import com.rest.webservices.medical.mapper.DoctorMapper;
import com.rest.webservices.medical.mapper.HospitalMapper;
import com.rest.webservices.medical.model.Doctor;
import com.rest.webservices.medical.model.Hospital;
import com.rest.webservices.medical.service.DoctorService;
import com.rest.webservices.medical.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final HospitalMapper mapper;

    @GetMapping
    public ResponseEntity<List<HospitalDTO>> readAll() throws Exception {
        List<HospitalDTO> list = hospitalService.readAll().stream()
                .map(mapper::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HospitalDTO> save(@RequestBody HospitalDTO dto) throws Exception {
        Hospital obj = hospitalService.save(mapper.convertToEntity(dto));
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        hospitalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
