package com.example.ecommerce.service;


import com.example.ecommerce.model.dto.LoginResponseDto;
import com.example.ecommerce.model.dto.SignUpResponseDto;
import com.example.ecommerce.model.entity.Role;
import com.example.ecommerce.model.entity.User;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class UserService {

    private final UserRepository userRepository;


    private final JwtTokenUtil jwtTokenUtil;


    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.jwtTokenUtil=jwtTokenUtil;
        this.passwordEncoder=passwordEncoder;
        this.roleRepository=roleRepository;
    }

    public SignUpResponseDto registerUser(User user) {
        // Check if username exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return new SignUpResponseDto(302,"user already exists");
        }
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);
        return new SignUpResponseDto(202,"user registered successfully");
    }

    public LoginResponseDto loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Generate and return JWT token
            String token= jwtTokenUtil.generateToken(existingUser);
            return new LoginResponseDto(202,"Login SuccessFull",token);
        }
        return new LoginResponseDto(303,"user does not exists",null);
    }
}