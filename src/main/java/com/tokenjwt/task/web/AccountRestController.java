package com.tokenjwt.task.web;

import com.tokenjwt.task.entities.AppUser;
import com.tokenjwt.task.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @Autowired
    private AccountService  accountService; 

    @PostMapping("/register")
    public AppUser register(@RequestBody  RegisterForm userForm ) {
        if(!userForm.getPassword().equals(userForm.getRepassword()))
            throw new RuntimeException("vous devez confirmer le mot de passe");
        
        AppUser userCheck= accountService.findUserByUsername(userForm.getUsername());
        if(userCheck != null)
            throw new RuntimeException("Surnom déjà utilisé, choisissez un autre");
        
        AppUser user= new AppUser();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());

        accountService.saveUser(user);
        accountService.addRoleToUser(userForm.getUsername(), "USER");
        return user;
    }
}