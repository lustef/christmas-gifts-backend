package com.lustef.christmas.repository;

import com.lustef.christmas.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

     Room findByName(String name);
}
