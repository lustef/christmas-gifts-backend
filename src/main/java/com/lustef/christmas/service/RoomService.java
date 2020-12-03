package com.lustef.christmas.service;

import com.lustef.christmas.entity.Room;
import com.lustef.christmas.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room save(Room room) { return roomRepository.save(room);}

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grid not found for ID " + id));
    }

    public Room findByName(String name){ return roomRepository.findByName(name);}
}
