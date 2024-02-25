package com.example.ecommerce.service;

import com.example.ecommerce.model.entity.User;
import com.example.ecommerce.model.entity.Wishlist;
import com.example.ecommerce.model.entity.WishlistItem;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.repository.WishlistItemRepository;
import com.example.ecommerce.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Wishlist> getUserWishlists(String userName) {
        return wishlistRepository.findByusername(userName);
    }
    public List<WishlistItem> getUserWishlists(Long wishlistId ) {
        return wishlistItemRepository.findBywishlistId(wishlistId);
    }

    public Wishlist createWishlist(String userName, Wishlist wishlist) {
        wishlist.setUsername(userName);
        return wishlistRepository.save(wishlist);
    }
    public WishlistItem createWishlistItem(Long wishListId, WishlistItem wishlistItem) {
        wishlistItem.setWishlistId(wishListId);
        return wishlistItemRepository.save(wishlistItem);
    }
    public void removeWishlistItem(Long ItemId) {
        wishlistItemRepository.deleteById(ItemId);
    }

    public void removeWishlist(Long wishlistId) {
        wishlistRepository.deleteById(wishlistId);
    }

    public Wishlist getWishlistById(Long wishlistId){
        return wishlistRepository.findById(wishlistId).orElse(null);
    }
}
