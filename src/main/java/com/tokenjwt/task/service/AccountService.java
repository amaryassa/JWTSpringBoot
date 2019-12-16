package com.tokenjwt.task.service;

import com.tokenjwt.task.entities.AppRole;
import com.tokenjwt.task.entities.AppUser;

public interface AccountService {
    
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public  void addRoleToUser(String username, String roleName);
    public AppUser findUserByUsername(String username);
}