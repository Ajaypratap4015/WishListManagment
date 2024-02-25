package com.example.ecommerce;


import com.example.ecommerce.model.entity.Role;
import com.example.ecommerce.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class WishListApplicationTest {

    @Autowired
    private WishListApplication wishListApplication;

    @MockBean
    private RoleRepository roleRepository;

    @Captor
    private ArgumentCaptor<Role> roleCaptor;

    @Test
    public void contextLoads(){
        Assertions.assertNotNull(wishListApplication);
    }

    @Test
    public void testDemoCommandLineRunner() throws Exception {
        Role expectedRole = new Role();
        expectedRole.setName("ROLE_ADMIN");

        // Mock the repository method
        when(roleRepository.save(roleCaptor.capture())).thenReturn(expectedRole);

        // Call the CommandLineRunner
        wishListApplication.demo(roleRepository).run();

        // Verify that the save method was called with the expected role
        Role actualRole = roleCaptor.getValue();
        assertEquals(expectedRole.getName(), actualRole.getName());


    }
}
