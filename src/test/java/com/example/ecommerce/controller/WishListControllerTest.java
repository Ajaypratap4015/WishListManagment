package com.example.ecommerce.controller;


import com.example.ecommerce.model.entity.Wishlist;
import com.example.ecommerce.model.entity.WishlistItem;
import com.example.ecommerce.service.WishlistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class WishListControllerTest {

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishListController wishListController;

    @Test
    void testGetUserWishLists(){
        String userName = "testUser";
        List<Wishlist> wishlists = new ArrayList<>();

        Mockito.when(wishlistService.getUserWishlists(userName)).thenReturn(wishlists);


        List<Wishlist> result = wishListController.getUserWishlists(userName);


        Assertions.assertNotNull(result);
        Assertions.assertEquals(wishlists, result);
    }


    @Test
    void testGetUserWishlistsById() {

        Long wishlistId = 1L;
        List<WishlistItem> wishlistItems = new ArrayList<>();

        Mockito.when(wishlistService.getUserWishlists(wishlistId)).thenReturn(wishlistItems);


        List<WishlistItem> result = wishListController.getUserWishlists(wishlistId);


        Assertions.assertNotNull(result);
        Assertions.assertEquals(wishlistItems, result);
    }

    @Test
    void testCreateWishlist() {

        String userName = "testUser";
        Wishlist wishlist = new Wishlist();
        wishlist.setName("Test Wishlist");


        Mockito.when(wishlistService.createWishlist(eq(userName), any(Wishlist.class))).thenReturn(wishlist);


        Wishlist result = wishListController.createWishlist(userName, wishlist);


        Assertions.assertNotNull(result);
        Assertions.assertEquals(wishlist, result);
    }

}
