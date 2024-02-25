package com.example.ecommerce.service;

import com.example.ecommerce.model.entity.Wishlist;
import com.example.ecommerce.model.entity.WishlistItem;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.repository.WishlistItemRepository;
import com.example.ecommerce.repository.WishlistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class WishlistServiceTest {

    @Mock
    private WishlistRepository wishlistRepository;

    @Mock
    private WishlistItemRepository wishlistItemRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private WishlistService wishlistService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserWishlists(){
        String userName = "testUser";
        List<Wishlist> wishlists = new ArrayList<>();

        Mockito.when(wishlistRepository.findByusername(userName)).thenReturn(wishlists);

        List<Wishlist> result = wishlistService.getUserWishlists(userName);
        Assertions.assertEquals(wishlists, result);

    }

    @Test
    void testGetUserWishlistItems(){
        Long wishlistID = 1L;
        List<WishlistItem> wishlistItems = new ArrayList<>();

        Mockito.when(wishlistItemRepository.findBywishlistId(wishlistID)).thenReturn(wishlistItems);

        List<WishlistItem> result = wishlistService.getUserWishlists(wishlistID);
        Assertions.assertEquals(wishlistItems, result);

    }

    @Test
    void testCreateWishlist(){
        String userName = "testUser";
        Wishlist wishlist = new Wishlist();

        wishlist.setWishlistId(1L);
        wishlist.setUsername(userName);

        Mockito.when(wishlistRepository.save(wishlist)).thenReturn(wishlist);

        Wishlist result = wishlistService.createWishlist("testUser", wishlist);
        Assertions.assertEquals(wishlist, result);

    }

    @Test
    void testCreateWishlistItem(){
        Long wishlistId = 1L;
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setItemId(1L);
        wishlistItem.setWishlistId(wishlistId);

        Mockito.when(wishlistItemRepository.save(wishlistItem)).thenReturn(wishlistItem);

        WishlistItem result = wishlistService.createWishlistItem(1L, wishlistItem);
        Assertions.assertEquals(wishlistItem, result);

    }

    @Test
    void testRemoveWishlistItem(){
        Long itemID = 1L;
        wishlistService.removeWishlistItem(itemID);

        Mockito.verify(wishlistItemRepository, Mockito.times(1)).deleteById(itemID);

    }

    @Test
    void testRemoveWishlist(){
        Long wishlistID = 1L;
        wishlistService.removeWishlist(wishlistID);

        Mockito.verify(wishlistRepository, Mockito.times(1)).deleteById(wishlistID);
    }
}
