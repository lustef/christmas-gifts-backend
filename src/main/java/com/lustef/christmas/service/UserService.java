package com.lustef.christmas.service;

import com.lustef.christmas.dto.UsernameAndPassword;
import com.lustef.christmas.dto.UsernameAndRole;
import com.lustef.christmas.entity.Room;
import com.lustef.christmas.entity.UserAccount;
import com.lustef.christmas.repository.RoomRepository;
import com.lustef.christmas.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserAccountRepository userAccountRepository;
    private final RoomRepository roomRepository;
    private final RandomString random = new RandomString(8);

    public UserAccount login(UsernameAndPassword usernameAndPassword) {
        UserAccount user = userAccountRepository.findByUsername(usernameAndPassword.getUsername());
        if(user.getPassword().equals(usernameAndPassword.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Grid not found for ID " + id));
    };

    public String findDesireByUsername(Long id) {
        UserAccount user = userAccountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Grid not found for ID " + id));
        return user.getDesire();
    }

    public UserAccount register(UsernameAndRole usernameAndRole) {
        Room room = null;
        if (usernameAndRole.getRoomId() == null) {
            room = roomRepository.save(Room.builder().name(random.nextString()).build());
        } else {
            Optional<Room> findRoom = roomRepository.findById(usernameAndRole.getRoomId());
            if (findRoom.isEmpty()) {
                room = roomRepository.save(Room.builder().name(random.nextString()).build());
            } else {
                room = findRoom.get();
            }
        }
        UserAccount newUser = new UserAccount();
        newUser.setPassword(random.nextString());
        newUser.setUsername(usernameAndRole.getUsername());
        newUser.setRole(usernameAndRole.getRole());
        newUser.setRoom(room);
        return userAccountRepository.save(newUser);
    }

    public UserAccount update(UserAccount user) {

        final UserAccount oldUserAccount = userAccountRepository.findById(user.getId()).orElseThrow(() -> new EntityNotFoundException("Grid not found for ID " + user.getId()));
        user.setId(oldUserAccount.getId());
        user.setUsername(oldUserAccount.getUsername());
        user.setPassword(oldUserAccount.getPassword());
        user.setRole(oldUserAccount.getRole());
        user.setRoom(oldUserAccount.getRoom());
        return userAccountRepository.save(user);
    }

}
