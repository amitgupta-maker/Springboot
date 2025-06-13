package com.example.hotel.controller;

import com.example.hotel.model.RoomAllotment;
import com.example.hotel.service.RoomAllotmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomAllotmentController {

    @Autowired
    private RoomAllotmentService service;

    @GetMapping("/rooms")
    public List<RoomAllotment> getAllRooms() {
        return service.getAllRooms();
    }

    @GetMapping("/room/{id}")
    public RoomAllotment getRoomById(@PathVariable int id) {
        return service.getRoomById(id);
    }

    @GetMapping("/rooms/type/{type}")
    public List<RoomAllotment> getRoomsByType(@PathVariable String type) {
        return service.getRoomsByType(type);
    }

    @PostMapping("/room")
    public RoomAllotment createRoom(@RequestBody RoomAllotment room) {
        return service.saveRoom(room);
    }

    @PutMapping("/room/{id}")
    public RoomAllotment updateRoom(@PathVariable int id, @RequestBody RoomAllotment room) {
        return service.updateRoom(id, room);
    }

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable int id) {
        service.deleteRoom(id);
    }
}
