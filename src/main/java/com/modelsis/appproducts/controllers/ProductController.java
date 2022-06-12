package com.modelsis.appproducts.controllers;

import com.modelsis.appproducts.entities.Product;
import com.modelsis.appproducts.entities.Type;
import com.modelsis.appproducts.services.IProductService;
import com.modelsis.appproducts.services.IProductTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
public class ProductController {
    /**
     * Using
     * dependencie Injection
     */
    private IProductService productService;
    private IProductTypeService productTypeService;

    public ProductController(IProductService productService, IProductTypeService productTypeService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> listAllProducts =  this.productService.listAllProducts();
        return ResponseEntity.ok().body(listAllProducts);
    }

    @PostMapping("/{typeId}")
    public ResponseEntity<Product> save(@RequestBody  Product product, @PathVariable(value = "typeId") Long typeId){
        log.info("producttypeId : {}",typeId);
        log.info("product : {}",product);
        Type type = productTypeService.findTypeById(typeId);
        log.info("productType find by id resutl : {}", type);
        product.setType(type);
        log.info("product with producttype set : {}",product);
        product = productService.save(product);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody @Validated Product product){
        product = productService.update(product);
        return ResponseEntity.ok().body(product);
    }
}
