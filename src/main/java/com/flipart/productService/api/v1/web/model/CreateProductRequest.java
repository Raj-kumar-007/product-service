package com.flipart.productService.api.v1.web.model;

import java.math.BigDecimal;

public record CreateProductRequest(String name, String description, BigDecimal price) {
}
