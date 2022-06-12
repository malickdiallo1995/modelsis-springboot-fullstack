package com.modelsis.appproducts;

import com.modelsis.appproducts.entities.Product;
import com.modelsis.appproducts.repositories.ProductRepository;
import com.modelsis.appproducts.services.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(classes = AppProductsApplication.class)
@Slf4j
@ActiveProfiles(profiles = "dev")
public class ProductApiTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private IProductService productService;

    @Test
    void contextLoads() {

    }

    @Test
    void getAllProducts(){
        List<Product> listAllProducts = productService.listAllProducts();
        Assertions.assertTrue(listAllProducts.size() != 0);
    }


}
