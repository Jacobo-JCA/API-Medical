package com.rest.webservices.medical.controller;

import com.rest.webservices.medical.dto.DoctorDTO;
import com.rest.webservices.medical.mapper.DoctorMapper;
import com.rest.webservices.medical.model.Doctor;
import com.rest.webservices.medical.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper mapper;


    @GetMapping
    public ResponseEntity<List<DoctorDTO>> readAll() throws Exception {
        List<DoctorDTO> list = doctorService.readAll().stream()
                .map(mapper::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<DoctorDTO>> readById(@PathVariable("id") Integer id) throws Exception {
        Doctor obj = doctorService.readById(id);
        DoctorDTO dto = mapper.convertToDTO(obj);
        EntityModel<DoctorDTO> entityModel = EntityModel.of(dto);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).readAll());
        entityModel.add(link.withRel("all-doctors"));
        return new ResponseEntity<>(entityModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> save(@Valid @RequestBody DoctorDTO dto) throws Exception {
        Doctor obj = doctorService.save(mapper.convertToEntity(dto));
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
