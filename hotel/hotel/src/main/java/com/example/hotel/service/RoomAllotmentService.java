package com.example.hotel.service;

import com.example.hotel.model.RoomAllotment;
import com.example.hotel.repository.RoomAllotmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAllotmentService {

    @Autowired
    private RoomAllotmentRepository repository;

    public List<RoomAllotment> getAllRooms() {
        return repository.findAll();
    }

    public RoomAllotment getRoomById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<RoomAllotment> getRoomsByType(String type) {
        return repository.findByRoomType(type);
    }

    public RoomAllotment saveRoom(RoomAllotment room) {
        return repository.save(room);
    }

    public RoomAllotment updateRoom(int id, RoomAllotment roomDetails) {
        RoomAllotment existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setStudentId(roomDetails.getStudentId());
            existing.setRoomType(roomDetails.getRoomType());
            existing.setDuration(roomDetails.getDuration());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteRoom(int id) {
        repository.deleteById(id);
    }
}
