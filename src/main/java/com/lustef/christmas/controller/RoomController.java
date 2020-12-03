package com.lustef.christmas.controller;

import com.lustef.christmas.entity.Room;
import com.lustef.christmas.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/add")
    public Room saveRoom(@RequestBody Room room) {return roomService.save(room);}

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.findById(id);
    }
}

