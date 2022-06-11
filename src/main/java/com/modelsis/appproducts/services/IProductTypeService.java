package com.modelsis.appproducts.services;

import com.modelsis.appproducts.entities.Type;

import java.util.List;

/**
 * Interface IProduct , respecting I in SOLID principal who stand for Interface segregation
 */
public interface IProductTypeService {
    Type save(Type type);
    List<Type> listAllType();

    Type findTypeById(Long id);
}
