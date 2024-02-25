package com.example.ecommerce.controller;


import com.example.ecommerce.model.dto.LoginResponseDto;
import com.example.ecommerce.model.entity.User;
import com.example.ecommerce.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginController loginController;

    @Test
    void testRegisterUser(){
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        LoginResponseDto responseDto = new LoginResponseDto(202, "Login Successful", "dummyToken");


        Mockito.when(userService.loginUser(any(User.class))).thenReturn(responseDto);

        LoginResponseDto result = loginController.loginUser(user);

        Assertions.assertEquals(responseDto, result);
    }

}
