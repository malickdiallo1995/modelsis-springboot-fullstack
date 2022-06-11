package com.modelsis.appproducts.services;

import com.modelsis.appproducts.entities.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface IProduct , respecting I in SOLID principal who stand for Interface segregation
 */
public interface IProductService {
    Product save(Product product);
   List<Product> listAllProducts();
    Product update(Product product);
    Product getProductById(Long id) throws Exception;
}
