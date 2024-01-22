package com.rest.webservices.medical.controller;

import com.rest.webservices.medical.dto.RoomDTO;
import com.rest.webservices.medical.mapper.RoomMapper;
import com.rest.webservices.medical.model.Room;
import com.rest.webservices.medical.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper mapper;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> readAll() throws Exception {
        List<RoomDTO> list = roomService.readAll().stream()
                .map(mapper::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> save(@RequestBody RoomDTO dto) throws Exception {
        Room obj = roomService.save(mapper.convertToEntity(dto));
        return new ResponseEntity<>(mapper.convertToDTO(obj), HttpStatus.CREATED);
    }
}
