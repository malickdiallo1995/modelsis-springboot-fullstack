package com.modelsis.appproducts.services.implementations;

import com.modelsis.appproducts.entities.Product;
import com.modelsis.appproducts.exceptions.ApiRequestExecption;
import com.modelsis.appproducts.exceptions.ExceptionCode;
import com.modelsis.appproducts.exceptions.ExceptionLevel;
import com.modelsis.appproducts.repositories.ProductRepository;
import com.modelsis.appproducts.repositories.ProductTypeRepository;
import com.modelsis.appproducts.services.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Log4j2
public class ProductServiceImplementation implements IProductService {
    ProductRepository productRepository;
    ProductTypeRepository productTypeRepository;

    public ProductServiceImplementation(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }



    @Override
    public Product save(Product product) {
    /*    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
*/
        log.info("product getting : {}",product);

        Product p = new Product();
       p.setName(product.getName());
       p.setDateCreated(new Date());
       p.setType(product.getType());
       log.info("product to save : {}",p);
       p = productRepository.save(p);
    if (p != null){
        return p;
    }else{
        throw   new ApiRequestExecption(
                ExceptionCode.PRODUCT_NOT_SAVED.getMessage(),
                ExceptionCode.PRODUCT_NOT_SAVED.getValue(),
                ExceptionLevel.ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Product getProductById(Long id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw   new ApiRequestExecption(
                    ExceptionCode.PRODUCT_NOT_FOUND.getMessage(),
                    ExceptionCode.PRODUCT_NOT_FOUND.getValue(),
                    ExceptionLevel.ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }else{
            return product.get();
        }
    }
}
