package com.myshopping.MyShopping.Service;

import com.myshopping.MyShopping.Models.AppUser;
import com.myshopping.MyShopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void registerUser(AppUser appUser){
        userRepository.save(appUser);
    }
    public AppUser getUserById(UUID id){
          AppUser user=userRepository.findById(id).orElse(null);
          return user;
    }

}
