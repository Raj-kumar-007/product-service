package com.flipart.productService.api.v1.web.model;

import java.math.BigDecimal;
import java.util.UUID;

public record APIProduct(UUID id, String name, String description, BigDecimal price) {
}
