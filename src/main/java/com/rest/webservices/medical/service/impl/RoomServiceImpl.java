package com.rest.webservices.medical.service.impl;

import com.rest.webservices.medical.model.Room;
import com.rest.webservices.medical.repository.GenericRepo;
import com.rest.webservices.medical.repository.RoomRepo;
import com.rest.webservices.medical.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl extends CRUDImpl<Room, Integer> implements RoomService {

    private final RoomRepo roomRepo;
    @Override
    protected GenericRepo<Room, Integer> getRepo() {
        return roomRepo;
    }
}
