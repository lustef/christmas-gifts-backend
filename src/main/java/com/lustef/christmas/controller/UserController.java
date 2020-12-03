package com.lustef.christmas.controller;

import com.lustef.christmas.dto.UsernameAndPassword;
import com.lustef.christmas.dto.UsernameAndRole;
import com.lustef.christmas.entity.UserAccount;
import com.lustef.christmas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserAccount saveUser(@RequestBody UsernameAndRole user) {return userService.register(user);}


    @PostMapping("/login")
    public UserAccount loginUser(@RequestBody UsernameAndPassword usernameAndPassword) {return userService.login(usernameAndPassword);}

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {return userService.findById(id);};

    @GetMapping("/desire/{id}")
    public String getUsersDesireByUserId(@PathVariable Long id) {return userService.findDesireByUsername(id);};

    @PatchMapping("/{id}/update")
    public UserAccount updateNote( @RequestBody UserAccount userAccount) {
       return userService.update(userAccount);
    }
}
