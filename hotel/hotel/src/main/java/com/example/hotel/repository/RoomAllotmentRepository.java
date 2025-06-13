package com.example.hotel.repository;

import com.example.hotel.model.RoomAllotment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomAllotmentRepository extends JpaRepository<RoomAllotment, Integer> {
    List<RoomAllotment> findByRoomType(String roomType);
}
