package com.flipart.productService.core.components;

import com.flipart.productService.api.v1.web.model.APIProduct;
import com.flipart.productService.api.v1.web.model.CreateProductRequest;
import com.flipart.productService.core.model.Product;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapper {
    public APIProduct mapToAPIProduct(Product product){
        return new APIProduct(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public Product mapToProduct(CreateProductRequest productRequest){
        return new Product(UUID.randomUUID(), productRequest.name(), productRequest.description(), productRequest.price());
    }
}

