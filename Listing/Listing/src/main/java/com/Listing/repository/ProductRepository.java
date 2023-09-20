package com.Listing.repository;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Producer, Long> {

    Page<Producer> findByCategory(String category, Pageable pageable);

    Page<Producer> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
    Page<Producer> searchProducts(@Param("keyword") String keyword, Pageable pageable);
}