package com.modelsis.appproducts.controllers;

import com.modelsis.appproducts.entities.Type;
import com.modelsis.appproducts.services.IProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productType")
public class ProductTypeController {
    private final IProductTypeService productTypeService;

    public ProductTypeController(IProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public ResponseEntity<Type> save(@RequestBody Type type) {
        System.out.println("productType insert : "+ type.toString());
        type = productTypeService.save(type);
        return ResponseEntity.ok().body(type);
    }

    @GetMapping
    public ResponseEntity<List<Type>> getAllProductTypes() {
        return ResponseEntity.ok().body(productTypeService.listAllType());
    }

    @GetMapping("/{typeId}")
    public Type findProductTypeById(@PathVariable(value = "typeId") Long typeId){
        Type type = productTypeService.findTypeById(typeId);
        return type;
    }
}
