package com.example.ecommerce.repository;


import com.example.ecommerce.model.entity.WishlistItem;
import org.junit.jupiter.api.Assertions;
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
public class WishlistItemRepositoryTest {

    @Mock
    private WishlistItemRepository wishlistItemRepository;

    @Test
    void testFindByWishlistId(){
        Long wishlistId = 1L;

        WishlistItem item1 = new WishlistItem();
        item1.setWishlistId(wishlistId);
        item1.setItemId(1L);
        item1.setName("Test Item 1");
        item1.setDescription("Description 1");
        item1.setPrice(19.99);
        item1.setLink("https://example.com/item1");
        item1.setCreatedAt(LocalDateTime.now());
        item1.setUpdatedAt(LocalDateTime.now());

        WishlistItem item2 = new WishlistItem();
        item2.setWishlistId(wishlistId);
        item2.setItemId(2L);
        item2.setName("Test Item 2");
        item2.setDescription("Description 2");
        item2.setPrice(29.99);
        item2.setLink("https://example.com/item2");
        item2.setCreatedAt(LocalDateTime.now());
        item2.setUpdatedAt(LocalDateTime.now());

        List<WishlistItem> wishlistItems = new ArrayList<>();
        wishlistItems.add(item1);
        wishlistItems.add(item2);

        // Mock the repository method
        when(wishlistItemRepository.findBywishlistId(wishlistId)).thenReturn(wishlistItems);

        // Call the repository method
        List<WishlistItem> result = wishlistItemRepository.findBywishlistId(wishlistId);

        // Assertions
        Assertions.assertNotNull(result);
        Assertions.assertEquals(wishlistItems, result);

    }

}
