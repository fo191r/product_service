package com.study.docker.service;

import com.study.common.exception.BusinessException;
import com.study.common.model.Product;
import com.study.common.repository.IProductRepository;
import com.study.docker.config.Config;
import com.study.docker.mapper.IProductMapper;
import com.study.docker.mapper.IProductsDetailsMapper;
import com.study.docker.openapi.model.CreateProductRequest;
import com.study.docker.openapi.model.CreateProductResponse;
import com.study.docker.openapi.model.GetProductsResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Log4j2
public class ProductService {

    @Autowired private IProductRepository productRepository;
    @Autowired private IProductsDetailsMapper productsDetailsMapper;
    @Autowired private IProductMapper productMapper;
    @Autowired private Config config;

    @Transactional(readOnly = true)
    public GetProductsResponse getProducts(){
        log.info("Retrieving the products");

        GetProductsResponse gpr = new GetProductsResponse();
        gpr.setData(productsDetailsMapper.dtoToResponse(productRepository.findAll()));
        return gpr;
    }

    @Transactional
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest){
        if(!config.getStorageId().equals("OPEN")) {
            log.error("No se guardo el producto status: {}", config.getStorageId());
            throw new BusinessException("No se puede realizar el guardado del producto", HttpStatus.INSUFFICIENT_STORAGE);
        }

        CreateProductResponse createProductResponse = new CreateProductResponse();
        createProductResponse.setData(Optional.of(productRepository.save(productMapper.requestToDto(createProductRequest)))
                                              .map(Product::getId)
                                              .orElseThrow(() -> new BusinessException("No se pudo realizar la creacion de producto", HttpStatus.INTERNAL_SERVER_ERROR)));

        return createProductResponse;
    }

}
