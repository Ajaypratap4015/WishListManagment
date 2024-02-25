package com.example.ecommerce.repository;


import com.example.ecommerce.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.when;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void testFindByUsername(){

        String username = "testUser";
        User user = new User();
        user.setUserId(1L);
        user.setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(user);

        User result = userRepository.findByUsername(username);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(username, result.getUsername());
    }
}
