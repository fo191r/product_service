package com.study.docker.mapper;

import com.study.common.model.Product;
import com.study.docker.openapi.model.CreateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.Date;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = {Date.class})
public interface IProductMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "createDate", expression = "java(new Date())")
    @Mapping(target = "id", ignore = true)
    Product requestToDto(CreateProductRequest createProductRequest);

}
