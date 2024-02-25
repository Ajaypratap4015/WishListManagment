package com.example.ecommerce.controller;

import com.example.ecommerce.model.entity.Wishlist;
import com.example.ecommerce.model.entity.WishlistItem;
import com.example.ecommerce.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishListController {

    @Autowired
    private WishlistService wishlistService;

    // Endpoint to get user's wishlists based on username
    @GetMapping("/getUserWishlists")
    public List<Wishlist> getUserWishlists(@RequestHeader String userName) {
        return wishlistService.getUserWishlists(userName);
    }

    // Endpoint to get all items in a wishlist based on wishlistId
    @GetMapping("/getAllItemInWishlist/{wishlistId}")
    public List<WishlistItem> getUserWishlists(@PathVariable Long wishlistId) {
        return wishlistService.getUserWishlists(wishlistId);
    }

    // Endpoint to create a new wishlist
    @PostMapping("/createWishlist")
    public Wishlist createWishlist(@RequestHeader String userName, @RequestBody Wishlist wishlist) {
        return wishlistService.createWishlist(userName, wishlist);
    }

    // Endpoint to remove a wishlist based on wishlistId
    @DeleteMapping("/removeWishlist/{wishlistId}")
    public void removeWishlist(@RequestHeader String userName, @PathVariable Long wishlistId) {
        wishlistService.removeWishlist(wishlistId);
    }

    // Endpoint to create a new wishlist item
    @PostMapping("/createWishlistItem/{wishListId}")
    public ResponseEntity<?> createWishlistItem(@PathVariable Long wishListId, @RequestBody WishlistItem wishlistItem) {
        try {
            // Check if the wishlist with the provided ID exists
            Wishlist wishlist = wishlistService.getWishlistById(wishListId);
            if (wishlist == null) {
                return ResponseEntity.notFound().build(); // Wishlist not found
            }

            // If the wishlist exists, proceed to add the item
            WishlistItem createdItem = wishlistService.createWishlistItem(wishListId, wishlistItem);
            return ResponseEntity.ok(createdItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint to remove a wishlist item based on itemId
    @DeleteMapping("/removeWishlistItem/{itemId}")
    public void removeWishlistItem(@PathVariable Long itemId) {
        wishlistService.removeWishlistItem(itemId);
    }
}
