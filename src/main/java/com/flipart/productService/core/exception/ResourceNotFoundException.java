package com.flipart.productService.core.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
