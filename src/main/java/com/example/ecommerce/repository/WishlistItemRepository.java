package com.example.ecommerce.repository;

import com.example.ecommerce.model.entity.Wishlist;
import com.example.ecommerce.model.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

    List<WishlistItem> findBywishlistId(Long wishListId);
}
