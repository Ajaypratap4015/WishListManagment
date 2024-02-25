import com.example.ecommerce.model.entity.Role;
import com.example.ecommerce.model.entity.User;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.util.JwtTokenUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private RoleRepository roleRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository,jwtTokenUtil,passwordEncoder,roleRepository);
    }


    @Test
    void testRegisterNewUser() {
        Role role = new Role();
//        role.setName("ROLE_ADMIN");
        User user = new User();
//        user.setUsername("Ajay");
//        user.setPassword("abc123");
//        user.setEmail("abc@gmail.com");
        Mockito.when(passwordEncoder.encode("abc123")).thenReturn("abc123");
        Mockito.when(roleRepository.findByName("ROLE_ADMIN")).thenReturn(Optional.of(role));
        Mockito.when(userRepository.findByUsername("Ajay")).thenReturn(null);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(202,userService.registerUser(user).getCode());
    }
    @Test
    void testRegisterOldUser() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        User user = new User();
        user.setUsername("Ajay");
        user.setPassword("abc123");
        user.setEmail("abc@gmail.com");
        Mockito.when(passwordEncoder.encode("abc123")).thenReturn("abc123");
        Mockito.when(roleRepository.findByName("ROLE_ADMIN")).thenReturn(Optional.of(role));
        Mockito.when(userRepository.findByUsername("Ajay")).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(302,userService.registerUser(user).getCode());
    }
}