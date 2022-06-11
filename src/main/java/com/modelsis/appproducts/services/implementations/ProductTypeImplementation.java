package com.modelsis.appproducts.services.implementations;

import com.modelsis.appproducts.entities.Type;
import com.modelsis.appproducts.exceptions.ApiRequestExecption;
import com.modelsis.appproducts.exceptions.ExceptionCode;
import com.modelsis.appproducts.exceptions.ExceptionLevel;
import com.modelsis.appproducts.repositories.ProductTypeRepository;
import com.modelsis.appproducts.services.IProductTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProductTypeImplementation implements IProductTypeService {
    ProductTypeRepository productTypeRepository;

    /**
     * Using Constructor Injection because injection with Autowired is now deprecated
     * @param productTypeRepository
     */
    public ProductTypeImplementation(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public Type save(Type type) {
        Type typebuild = Type.builder().name(type.getName()).build();
        typebuild = productTypeRepository.saveAndFlush(typebuild);
        if (typebuild != null){
          return typebuild;
        }else{
            throw   new ApiRequestExecption(
                    ExceptionCode.PRODUCT_TYPE_NOT_SAVED.getMessage(),
                    ExceptionCode.PRODUCT_TYPE_NOT_SAVED.getValue(),
                    ExceptionLevel.ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public List<Type> listAllType() {
        return productTypeRepository.findAll();
    }

    @Override
    public Type findTypeById(Long id) {
        Optional<Type> productType = productTypeRepository.findById(id);
        if(productType.isPresent()){
            log.debug("ProductType Found : {}",productType.get());
            return productType.get();
        }else{
            log.debug("ProductType not Found ");

            throw   new ApiRequestExecption(
                    ExceptionCode.PRODUCT_TYPE_NOT_FOUND.getMessage(),
                    ExceptionCode.PRODUCT_TYPE_NOT_FOUND.getValue(),
                    ExceptionLevel.ERROR,
                    HttpStatus.NOT_FOUND
            );
        }

    }
}
