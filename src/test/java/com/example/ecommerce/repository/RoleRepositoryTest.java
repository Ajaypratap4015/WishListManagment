package com.example.ecommerce.repository;

import com.example.ecommerce.model.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class RoleRepositoryTest {

    @Mock
    private RoleRepository roleRepository;

    @Test
    void testFindByName(){
        String roleName = "ROLE_ADMIN";
        Role role = new Role();
        role.setId(1);
        role.setName(roleName);

        when(roleRepository.findByName(roleName)).thenReturn(Optional.of(role));

        Optional<Role> result = roleRepository.findByName(roleName);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(role, result.get());
    }

}
