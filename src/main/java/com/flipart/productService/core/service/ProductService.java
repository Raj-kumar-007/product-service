package com.flipart.productService.core.service;

import com.flipart.productService.api.v1.web.model.CreateProductRequest;
import com.flipart.productService.core.components.ProductMapper;
import com.flipart.productService.core.dao.ProductDao;
import com.flipart.productService.core.exception.ResourceNotFoundException;
import com.flipart.productService.core.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;
    private final ProductMapper productMapper;

    public List<Product> getAllProduct(){
        return productDao.findAll();
    }

    public Product getProduct(UUID id){
        if(productDao.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Product is not present.");
        }
        return productDao.findById(id).get();
    }

    public UUID insertProduct(CreateProductRequest createProductRequest) {
        return productDao.insert(productMapper.mapToProduct(createProductRequest)).getId();
    }

    public void delete(UUID productId) {
        var product = getProduct(productId);
        productDao.delete(product);
    }
}
