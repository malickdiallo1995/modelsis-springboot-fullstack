package com.modelsis.appproducts.repositories;

import com.modelsis.appproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *Product Repository using JPARepository interface
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
