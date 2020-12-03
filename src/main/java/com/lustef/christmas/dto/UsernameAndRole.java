package com.lustef.christmas.dto;

import com.lustef.christmas.entity.UserAccount;
import lombok.Data;

@Data
public class UsernameAndRole {
    private String username;
    private UserAccount.Role role;
    private Long roomId;

}
