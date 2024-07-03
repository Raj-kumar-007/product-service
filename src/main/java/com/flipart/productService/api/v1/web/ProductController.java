package com.flipart.productService.api.v1.web;

import com.flipart.productService.api.v1.web.model.APIProduct;
import com.flipart.productService.api.v1.web.model.CreateProductRequest;
import com.flipart.productService.core.components.ProductMapper;
import com.flipart.productService.core.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<APIProduct> getAllProducts(){
        return productService.getAllProduct().stream()
                .map(productMapper::mapToAPIProduct)
                .toList();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public APIProduct getProductById(@PathVariable("productId") UUID productId) {
        log.info("Getting the product with product Id = {}", productId);
        return productMapper.mapToAPIProduct(productService.getProduct(productId));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UUID insertProduct(@RequestBody CreateProductRequest createProductRequest){
        var productId = productService.insertProduct(createProductRequest);
        log.info("Trying to create a new product with productId = {}", productId);
        return productId;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") UUID productId) {
        log.info("Trying to delete the product with product id = {}", productId);
        productService.delete(productId);
    }

}
