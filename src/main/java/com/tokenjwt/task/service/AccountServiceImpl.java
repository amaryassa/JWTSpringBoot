package com.tokenjwt.task.service;

import com.tokenjwt.task.dao.RoleRepository;
import com.tokenjwt.task.dao.UserRepository;
import com.tokenjwt.task.entities.AppRole;
import com.tokenjwt.task.entities.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;  

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {

        String hashPassword= bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);

        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
         
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role =  roleRepository.findByRoleName(roleName);
        AppUser user =  userRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}