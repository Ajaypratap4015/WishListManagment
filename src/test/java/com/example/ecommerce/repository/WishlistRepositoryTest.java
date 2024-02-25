package com.example.ecommerce.repository;


import com.example.ecommerce.model.entity.Wishlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class WishlistRepositoryTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @BeforeEach
    void setUp(){
        Wishlist wishlist1 = new Wishlist();
        wishlist1.setWishlistId(1L);
        wishlist1.setUsername("testUser1");
        wishlist1.setName("Wishlist 1");
        wishlist1.setDescription("Description 1");
        wishlist1.setCreatedAt(LocalDateTime.now());
        wishlist1.setUpdatedAt(LocalDateTime.now());

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setWishlistId(2L);
        wishlist2.setUsername("testUser2");
        wishlist2.setName("Wishlist 2");
        wishlist2.setDescription("Description 2");
        wishlist2.setCreatedAt(LocalDateTime.now());
        wishlist2.setUpdatedAt(LocalDateTime.now());

        List<Wishlist> wishlists = new ArrayList<>();
        wishlists.add(wishlist1);
        wishlists.add(wishlist2);

        when(wishlistRepository.findByusername("testUser1")).thenReturn(wishlists);

    }

    @Test
    void testFindByUsername(){
        List<Wishlist> result = wishlistRepository.findByusername("testUser1");


        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());

        Assertions.assertEquals("Wishlist 1", result.get(0).getName());
        Assertions.assertEquals("Description 1", result.get(0).getDescription());
    }
}
