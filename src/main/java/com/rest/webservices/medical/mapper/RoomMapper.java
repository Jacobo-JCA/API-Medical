package com.rest.webservices.medical.mapper;

import com.rest.webservices.medical.dto.RoomDTO;
import com.rest.webservices.medical.model.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomMapper {

    private final ModelMapper mapper;

    public RoomDTO convertToDTO(Room obj) {
        return mapper.map(obj, RoomDTO.class);
    }
    public Room convertToEntity(RoomDTO dto) {
        return mapper.map(dto, Room.class);
    }
}
