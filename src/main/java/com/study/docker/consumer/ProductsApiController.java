package com.study.docker.consumer;

import com.study.docker.openapi.api.ProductsApi;
import com.study.docker.openapi.model.CreateProductRequest;
import com.study.docker.openapi.model.CreateProductResponse;
import com.study.docker.openapi.model.GetProductsResponse;
import com.study.docker.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
@RestController
public class ProductsApiController implements ProductsApi {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<CreateProductResponse> createProduct(CreateProductRequest createProductRequest) {
        log.info("Receiving the request from [POST] /products - Body: {}", createProductRequest);
        return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GetProductsResponse> getProducts() {
        log.info("Receiving the request from [GET] /products");
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}
