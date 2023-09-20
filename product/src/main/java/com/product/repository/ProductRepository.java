package com.product.repository;

import com.product.entity.Product;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//
//   @Transactional
//    @Modifying
//    @Query("UPDATE Product AS product SET product.isDeleted = true WHERE product.id IN :productIds")
//   void deleteProducts(List<Long> productIds);
//
//   List<Product> findByIsDeletedFalse();

}