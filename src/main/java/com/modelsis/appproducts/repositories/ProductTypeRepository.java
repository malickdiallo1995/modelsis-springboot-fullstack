package com.modelsis.appproducts.repositories;

import com.modelsis.appproducts.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *ProductType Repository using JPARepository interface
 */
@Repository
public interface ProductTypeRepository extends JpaRepository<Type,Long> {
 }
